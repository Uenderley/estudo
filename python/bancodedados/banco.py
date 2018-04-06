import psycopg2
import os
import re
import datetime
from mapeamentoBanco import MapeamentoBanco
from arquivos import Arquivos

mapeamento = MapeamentoBanco("AC", "bancohost", "port", "pje", "usur", "pass", "bancohost2", "port2", "user2", "pass2", "pje")

conCand = psycopg2.connect(host=mapeamento.cand_host, database=mapeamento.cand_banco, user=mapeamento.cand_usuario, password=mapeamento.cand_senha, port=mapeamento.cand_porta)
curCand = conCand.cursor()

conProd = psycopg2.connect(host=mapeamento.prod_host, database=mapeamento.prod_banco, user=mapeamento.prod_usuario, password=mapeamento.prod_senha, port=mapeamento.prod_porta)
curProd = conProd.cursor()

sql = "select id_fluxo, ds_fluxo, ds_xml from core.tb_fluxo where in_ativo = true and ds_xml LIKE %s"
query = curCand.mogrify(sql, ('%<assignment pooled-actors="#"%', ))
curCand.execute(query)
conCand.commit()

recset = curCand.fetchall()

for rec in recset:    
    xml_cand = rec[2]

    nome_arquivo = "/Cand__"+rec[1]+"__.txt"    
    arquivo = Arquivos()
    arquivo.salvar_fluxo(mapeamento.nome, xml_cand, nome_arquivo)

    sqlProd = "select ds_fluxo, ds_xml from core.tb_fluxo where id_fluxo = %s"
    queryProd = curProd.mogrify(sqlProd, (rec[0], ))
    curProd.execute(queryProd)
    
    rec_set_prod = curProd.fetchall()
    for rec_prod in rec_set_prod:
        xml_prod = rec_prod[1]

        nome_arquivo = "/Prod__"+rec[1]+"__.txt"
        arquivo = Arquivos()
        arquivo.salvar_fluxo(mapeamento.nome, xml_prod, nome_arquivo)
        
        print('Fluxo alterado ' + str(rec[1]))
        now = datetime.datetime.now()
        curCand.execute("UPDATE core.tb_fluxo SET in_publicado=true, dt_inicio_publicacao=(%s), ds_xml=(%s)  WHERE id_fluxo = (%s)", (now, xml_prod, rec[0],))
        conCand.commit()


conProd.close()
conCand.close()

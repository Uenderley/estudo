import pdfkit
import os
import psycopg2
import re
import datetime

from flask import Flask

app = Flask(__name__)

@app.route("/gerarTodos")
def gerarTodosOsPdfs():
    pdfkit.from_file('teste.html', 'micro.pdf')
    return "PDFs Gerados!"

@app.route("/gerarPdf")
def gerarPdf():
    obterArquivo()
    return "PDF Gerado!"


def obterArquivo():
    dt1 = datetime.datetime.now();

    conexao = psycopg2.connect(host='dolly.tse.jus.br', database='pje', user='sedescv', password='vsedesc', port='5444')
    curCand = conexao.cursor()

    sqlProd = "select id_processo_documento_bin, ds_modelo_documento, nr_tamanho from core.tb_processo_documento_bin where ds_extensao = 'text/html' and ds_modelo_documento is not null and nr_documento_storage is null and nr_tamanho is not null order by nr_tamanho DESC limit 10"
    curCand.execute(sqlProd)
    
    recset = curCand.fetchall()
    conexao.commit()

    for modelo in recset:
        pdfkit.from_string(modelo[1], str(modelo[0]) + '.pdf')

    dt2 = datetime.datetime.now();
    
    dt_diferenca = dt2 - dt1
    print(dt_diferenca.total_seconds())
    

#pip install Flask
#pip install psycopg2
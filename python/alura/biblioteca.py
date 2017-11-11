from datetime import date

def gera_nome_convite(convite):
	posicao_final = len(convite)
	posicao_inicial = posicao_final - 4
	parte1 = convite[0:4]
	parte2 = convite[posicao_inicial:posicao_final]
	return parte1 + ' ' + parte2

def envia_convite(para):
	print 'Enviando convite para %s' % (para)

def processa_convite(convite):
	nome = gera_nome_convite(convite)
	envia_convite(nome)

def cadastrar(nomes):
	print 'Digite o nome'
	nome = raw_input()
	nomes.append(nome)

def remover(nomes):
    print 'Qual nome voce gostaria de remover'
    nome = raw_input()
    nomes.remove(nome)

def gerar_error():
	raise ValueError('TOMAAA na face')	

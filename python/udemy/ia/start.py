from recomendacao import avaliacoes
from math import sqrt

def inicio():
    valor = avaliacoes['Ana']['Star Trek']
    print (valor)

def calculoEuclidiano(usuario1, usuario2):
    si = {}

    for item in avaliacoes[usuario1]:
        if(item in avaliacoes[usuario2]):
            si[item] = 1

    if len(si) == 0:
        return 0

    soma = sum([pow(avaliacoes[usuario1][item] - avaliacoes[usuario2][item],2)
                for item in avaliacoes[usuario1] if item in avaliacoes[usuario2]]) 
    return 1/(1+sqrt(soma))

    #valorEuclidiano = sqrt(pow(3-3,2) + pow(3.5-4,2))
    #print(1/(2+valorEuclidiano))

def getSimilares(usuario):
    similaridade= [(calculoEuclidiano(usuario, outro), outro)
                    for outro in avaliacoes if outro != usuario]
    
    similaridade.sort()
    similaridade.reverse()

    return similaridade

def getRecomendacoes(ususario):
    totais={}
    somaSimilaridade={}
    for outro in avaliacoes:
        if outro == ususario: continue
        similaridade = calculoEuclidiano(ususario, outro)

        if similaridade <= 0: continue

        for item in avaliacoes[outro]:
            if item not in avaliacoes[ususario]:
                totais.setdefault(item,0)
                totais[item] += avaliacoes[outro][item] * similaridade
                somaSimilaridade.setdefault(item,0)
                somaSimilaridade[item] += similaridade

    rankings=[(total / somaSimilaridade[item], item) for item, total in totais.items()] 
    rankings.sort()
    rankings.reverse()
    return rankings

recomendacoes = getRecomendacoes('Leonardo')
print('Recomendacoes: ----------------------------')
print(recomendacoes)
print('Recomendacoes: ----------------------------')

print('Calculo: ')
valor = calculoEuclidiano('Pedro','Marcos')
print(valor)

print(getSimilares('Ana'))
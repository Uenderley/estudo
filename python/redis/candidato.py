#Para instalar a library do redis (sudo pip install redis)
import redis

r = redis.StrictRedis(host='localhost', port=6379, charset="utf-8", decode_responses=True)
r.set('A', 'candidato1')
r.set('B', 'candidato1')
r.set('C', 'candidato2')
r.set('D', 'candidato1')
r.set('E', 'candidato2')
r.set('F', 'candidato2')
r.set('G', 'candidato1')
r.set('H', 'candidato1')
r.set('I', 'candidato1')

chaves = r.keys('*')
candidatos = []
for chave in chaves:
    candidato = r.get(chave)
    candidatos.append(candidato)

print(candidatos.count("candidato1"))
print(candidatos.count("candidato2"))

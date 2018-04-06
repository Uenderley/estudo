#Para instalar a library do redis (sudo pip install redis)
import redis

r = redis.StrictRedis(host='localhost', port=6379, charset="utf-8", decode_responses=True)
r.set('A', 'candidato1')
r.set('B', 'candidato1')
r.set('C', 'candidato1')
r.set('D', 'candidato2')
r.set('E', 'candidato2')
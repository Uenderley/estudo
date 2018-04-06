#Para instalar a library do redis (sudo pip install redis)
import redis

r = redis.StrictRedis(host='localhost', port=6379, charset="utf-8", decode_responses=True)

a = [0, 1, 1, 2, 3, 5, 8, 13]
b = [0, 1, 1, 2 ,3]

r.set('CarrinhoA', a)
r.set('CarrinhoB', b)

value = r.get('CarrinhoA')
print(value)


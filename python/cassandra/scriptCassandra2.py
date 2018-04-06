#sudo pip install cassandra-driver
from cassandra.cluster import Cluster

cluster = Cluster()
session = cluster.connect('aula')

session.execute("""
    insert into users (id, lastname, age, city, email, firstname) values
    (uuid(), 'Jones', '35', 'Austin', 'bob@gmail.com', 'Bob');
""")

result = session.execute("""
    select * from users where lastname='Jones' allow filtering;
""")

print(result[0].age, result[0].lastname)


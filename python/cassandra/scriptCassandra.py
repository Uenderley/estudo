#sudo pip install cassandra-driver
from cassandra.cluster import Cluster

cluster = Cluster()
session = cluster.connect('aula')

session.execute("""
    CREATE TABLE users (
        id uuid PRIMARY KEY,
        lastname text,
        age text,
        city text,
        email text,
        firstname text
    );
""")


import psycopg2

con = psycopg2.connect(host='pjebdcand.tse.jus.br', database='pje',
user='pje', password='pje', port='9009')
cur = con.cursor()
sql = 'select * from core.tb_fluxo'
cur.execute(sql)
con.commit()
recset = cur.fetchall()
print (recset)
con.close()
import pandas as pd

#Tratar o arquivo tsv
df = pd.read_csv('/home/uenderley/Documentos/puc/08-Tecnologias-para-o-Ecosistema-de-Big-Data/data.tsv',delimiter='\t', low_memory=False, na_values='\\N')

#mostra uma parte dos resultados
print (df.head())

#converte em arquivo csv já tratado
df.to_csv('/home/uenderley/Documentos/puc/08-Tecnologias-para-o-Ecosistema-de-Big-Data/title.basics.csv', index=False)

#le o arquivo csv
df = pd.read_csv('/home/uenderley/Documentos/puc/08-Tecnologias-para-o-Ecosistema-de-Big-Data/title.basics.csv')
print (df.head())
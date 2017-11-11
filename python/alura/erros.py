from biblioteca import *
arquivo = None
try:
    gerar_error()    
    open('nao_existe.txt','r')
    print('arquivo foi aberto')
    arquivo.close()



except IOError as erro:
    print('Deu Erro %s') % (erro)
finally:
    print('Acabou')
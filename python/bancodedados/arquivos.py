import os

class Arquivos(object):
    diretorio = '/home/uenderley/github/estudo/python/bancodedados/fluxos/'

    def salvar_fluxo(self, uf, arquivo, nome_arquivo):
        self.diretorio = self.diretorio + uf
        if not os.path.exists(self.diretorio):
            os.makedirs(self.diretorio)

        txt_file = open(self.diretorio + nome_arquivo, 'w')
        txt_file.write(arquivo)
        txt_file.close()  
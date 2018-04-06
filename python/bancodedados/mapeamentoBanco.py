class MapeamentoBanco(object):
    prod_host = ''
    prod_porta = ''
    prod_banco = ''
    prod_usuario = ''
    prod_senha = ''
    cand_host = ''
    cand_porta = ''
    cand_banco = ''
    cand_usuario = ''
    cand_senha = ''
    nome = ''

    def __init__(self, nome, prod_host, prod_porta, prod_banco, prod_usuario, prod_senha, cand_host, cand_porta, cand_banco, cand_usuario, cand_senha):
        self.nome = nome
        self.prod_host    = prod_host
        self.prod_porta   = prod_porta
        self.prod_banco   = prod_banco
        self.prod_usuario = prod_usuario
        self.prod_senha   = prod_senha
        self.cand_host    = cand_host
        self.cand_porta   = cand_porta
        self.cand_banco   = cand_banco
        self.cand_usuario = cand_usuario
        self.cand_senha   = cand_senha

    def mostrarMapeamento(self):
        print ('Nome : ',self.nome_uf, " Producao : ", self.banco_producao, " CAND : ", self.banco_cand)
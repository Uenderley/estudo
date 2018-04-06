##Criando o projeto
virtualenv -p python3 envDjango
pip install django
django-admin startproject controle_gastos .

#Criação da app
python manage.py startapp contas


##Banco de dados
#Criação do banco de dados
python manage.py migrate

#Alterando um database cria o arquivo de migraçao
python manage.py makemigrations

#Aplicando as alterações no banco
python manage.py migrate

#Rodar o servidor
python manage.py runserver

#Criar um superuser
python manage.py createsuperuser
--admin
--contasadmin



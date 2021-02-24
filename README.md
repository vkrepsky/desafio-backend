# Desafio backend

## Dependências

As dependências nessessárias estão no arquivo pom.xml 
e são normalmente baixadas
automaticamente pela IDE

## Rodar a aplicação

Utilize a IDE para iniciar a aplicação

### URL default

O URL default é http://localhost:8080/

#### Exemplo de request

Todos os requests são feitos pelo frontend, entretando se quiserem testar separadamente, aqui tem alguns exemplos

adicionar hospede:

metodo = POST

url = http://localhost:8080/set

{
	"nome":"fulano",
	"telefone":"(47) 99999-9999",
	"dataCheckIn":"2021-02-21T22:00:00",
	"dataCheckOut":"2021-02-27T08:00",
	"adicionalVeiculo":false
}

Buscar por nome:

metodo = GET

url = http://localhost:8080/get/nome?nome=fulano

Buscar todos:

metodo = GET

url = http://localhost:8080/get/all

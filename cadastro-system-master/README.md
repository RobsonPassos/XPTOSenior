# Desafio Senior
WebService comunica na arquitetura REST via JASON para ler um arquivo CSV e manter os dados.


#Implementação

##Nesse projeto utilizei SpringBoot para executar minha aplicação JavaEE com banco H2.
###Tecnologias utilizadas:

-Maven
-SpringBoot
-JSON
-REST
-BANCO H2
-JAVA 8

##	1. Ler o arquivo CSV das cidades para a base de dados; POST (PATH/city/importa) (Content-Disposition: form-data; name="uploadfile"; filename="path/cidades.csv)

##	2. Retornar somente as cidades que são capitais ordenadas por nome; (PATH/city/capitais)

##	3. Retornar o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades; (PATH/city/estadocommaisemenoscidadeesuaqnt)
###	extra:
####	Retorna estado com mais cidades (PATH/city/estadocommaiscidades)
####	Retorna estado com menos cidades (PATH/city/estadocommenoscidades)

##	4. Retornar a quantidade de cidades por estado; (PATH/city/qntcidadesporestado)

##	5. Obter os dados da cidade informando o id do IBGE; (PATH/city/cidadeporid/{id})

##	6. Retornar o nome das cidades baseado em um estado selecionado; (PATH/city/nomecidadesporestado/{uf})

##	7. Permitir adicionar uma nova Cidade; (PATH/city/{cidade}) //objeto cidade está vindo nulo, nao sei o pq

##	8. Permitir deletar uma cidade; (PATH/city/{id})

##	9. Permitir selecionar uma coluna (do CSV) e através dela entrar com uma string para filtrar. retornar assim todos os objetos que contenham tal string; (PATH/city/pesquisacoluna?{column=?}&{key=?})

##	10. Retornar a quantidade de registro baseado em uma coluna. Não deve contar itens iguais; (PATH/city/contarcoluna/{column}

##	11. Retornar a quantidade de registros total; (PATH/city/totalcidades)

##	12. Dentre todas as cidades, obter as duas cidades mais distantes uma da outra com base na localização (distância em KM em linha reta); (PATH/city/maiordistancia)

Execute com springApp


# API Test Nexfar

Técnologias envolvidas  Srping Boot, Mongo DB, Swagger.


# Endpoint

http://localhost:8080/api/product/search
http://localhost:8080/

## Swagger

http://localhost:8080/swagger-ui.html

## Detalhamento

Confesso que não foi a melhor prática mas.. Ao chamar o endpoint  /api/product/search devemos informar no Header o id do cliente a pesquisar e no body passar o nome do item a pesquisar as pesquisa é feito seguindo o padrão do LIKE no SQL %itemapesquisar% para que o retorno dos itens seja maior
utilizei o Mongo db conforme o teste pedia, ao fazer esta requisição eu verifico se o id do cliente informado existe, caso não já informo um erro notFound (404) se sim verifico se o item pesquisado no body existe vejo se há restrições para este item caso sim pego os valores das restrições e aplico retornando uma lista de objetosDTO, basicamente isso..

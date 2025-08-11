## O que é gRPC?
gRPC (g de "Google", mas com o significado mudando a cada nova versão) é um sistema de Remote Procedure Call moderno, focado em alta performance e eficiência. Ele foi projetado para comunicação entre microsserviços e sistemas distribuídos.

Ele se diferencia de implementações RPC mais antigas por adotar um conjunto de tecnologias específicas que o tornam incrivelmente rápido e eficiente:

HTTP/2: Ao invés de usar o HTTP/1.1 tradicional (usado por muitas APIs REST, por exemplo), o gRPC é construído sobre o protocolo HTTP/2. Isso permite recursos como a multiplexação (várias requisições e respostas em uma única conexão), comunicação bidirecional (streaming) e compressão de cabeçalhos, o que reduz a latência e o consumo de rede.

Protocol Buffers (Protobuf): Este é o formato de serialização de dados padrão do gRPC. Ao invés de usar formatos de texto como JSON ou XML, o Protobuf serializa os dados em um formato binário compacto. Isso torna as mensagens significativamente menores e mais rápidas de serem processadas.

Geração automática de código: Usando um arquivo de definição de serviço (um arquivo .proto), o gRPC gera automaticamente o código do cliente e do servidor em diversas linguagens. Isso elimina a necessidade de escrever manualmente o código de comunicação, garantindo que o cliente e o servidor tenham um "contrato" de comunicação rigoroso.




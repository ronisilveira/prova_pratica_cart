# Prova prática - Corrida de cart
### Interpretação das regras de domínio

Estou considerando que o log é gerado cada vez que um piloto cruza a linha de chegada e que o número da volta bem como o tempo da volta e a velocidade média se referem à volta que acabou de ser concluída.

Como fiquei em dúvida com relação às regras do domínio, decidi implementar duas estratégias diferentes para avaliar o resultado da corrida. Ao iniciar o programa o usuário poderá selecionar qual das duas estratégias pretende usar.

Na primeira estratégia, apesar de o enunciado dizer "A corrida termina quando o primeiro colocado completa 4 voltas", estou considerando todos os dados do log, ou seja, estou considerando que a corrida só termina quando todos os pilotos cruzam a linha de chegada na quarta volta ou desistem da corrida. Isso para todas as avaliações solicitadas.

Na segunda estratégia, estou considerando que a corrida termina mesmo quando o primeiro colocado completa a quarta volta. Qualquer fato registrado após esse momento será desconsiderado, ou seja, somente um piloto completará quatro voltas e os demais terão computadas somente as voltas completadas antes do final da prova (Quando um dos participantes completa a quarta volta). O número de voltas completadas, o tempo total de prova, a melhor volta de cada piloto e a melhor volta da corrida só levará em consideração o que acontecer até o momento que o primeiro piloto completa a quarta volta. Dados referentes a voltas completadas após o final da prova serão considerados somente para definir a posição de chegada e o cálculo do tempo que cada piloto demorou para cruzar a linha de chegada após o vencedor.

### Tecnologias utilizadas

Foram utilizadas basicamente as bibliotecas nativas do java 8 incluindo a api de streams. 
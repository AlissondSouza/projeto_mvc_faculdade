Sistema de Controle de Aluguel de 
Quadra Esportiva 
Tabelas Identificadas 
1. Cliente 
Armazena os dados dos clientes que alugam a quadra. 
Campo Tipo 
id 
nome 
int 
Descrição 
Identificador único do cliente 
String Nome completo do cliente 
telefone String Telefone de contato do 
cliente 
2. Horário 
Representa os horários disponíveis para aluguel da quadra. 
Campo 
id 
Tipo 
int 
Descrição 
Identificador único do horário 
descricao 
String 
Descrição do horário (ex: "08:00 - 09:00") 
valorPorHora double Valor cobrado por esse horário 
disponivel 
boolea
n 
Indica se o horário está livre ou ocupado 
3. Aluguel 
Registra cada locação realizada, vinculando cliente e horário. 
Campo Tipo 
id 
int 
Descrição 
Identificador único do aluguel 
cliente 
Cliente Referência ao cliente que reservou 
horario Horario Referência ao horário reservado 
data 
valor 
String 
Data do aluguel (formato dd/MM/yyyy) 
double Valor cobrado neste aluguel 
Regras de Negócio Identificadas 
RN01 — Nome do cliente não pode ser vazio 
O sistema não deve permitir o cadastro de um cliente sem informar o nome. 
RN02 — Horário não pode ter valor negativo 
Ao cadastrar um horário, o valor por hora deve ser maior que zero. 
RN03 — Não é permitido reservar horário já ocupado 
Antes de registrar um aluguel, o sistema verifica se o horário selecionado está 
disponível. Caso esteja ocupado, a reserva é negada. 
RN04 — Cálculo automático do valor total diário 
O sistema deve somar todos os valores de aluguéis de um mesmo cliente em 
um determinado dia, calculando o total automaticamente. 
RN05 — Consulta de aluguéis por data 
O sistema deve permitir listar todos os aluguéis realizados em uma data 
específica. 
RN06 — Telefone obrigatório 
O cliente deve ser cadastrado com telefone informado (não vazio). 
 Estrutura dos Projetos 

quadra-esportiva/ 

├── README.md 

├── projeto1/          → Classes simples sem padrão MVC 

│   └── src/main/java/quadra/ 

│       ├── Cliente.java 

│       ├── Horario.java 

│       ├── Aluguel.java 

│       ├── SistemaAluguel.java 

│       └── Main.java 

│ 

└── projeto2/          → Refatorado com padrão MVC 
    
    └── src/main/java/quadra/ 
        
        ├── model/ 
        
        │   ├── Cliente.java 
        
        │   ├── Horario.java 
        
        │   └── Aluguel.java 
        
        ├── repository/ 
        
        │   ├── ClienteRepository.java 
        
        │   ├── HorarioRepository.java 
        
        │   └── AluguelRepository.java 
        
        ├── controller/ 
        
        │   ├── ClienteController.java 
        
        │   ├── HorarioController.java 
        
        │   └── AluguelController.java 
        
        ├── view/ 
        
        │   └── SistemaView.java 
        
        └── Main.java 
 
 

# 🏟️ Sistema de Controle de Aluguel de Quadra Esportiva

Sistema desenvolvido para gerenciar o aluguel de quadras esportivas, permitindo o cadastro de clientes, controle de horários disponíveis e registro de reservas.

---

## 📌 Funcionalidades

- Cadastro de clientes
- Gerenciamento de horários disponíveis
- Registro de aluguéis
- Verificação de disponibilidade de horários
- Cálculo automático de valores
- Consulta de aluguéis por data

---

## 🗂️ Modelagem do Sistema

### 👤 Cliente

Armazena os dados dos clientes que alugam a quadra.

| Campo     | Tipo   | Descrição                          |
|----------|--------|----------------------------------|
| id       | int    | Identificador único do cliente   |
| nome     | String | Nome completo do cliente         |
| telefone | String | Telefone de contato              |

---

### ⏰ Horário

Representa os horários disponíveis para aluguel da quadra.

| Campo         | Tipo     | Descrição                                      |
|--------------|----------|-----------------------------------------------|
| id           | int      | Identificador único do horário                |
| descricao    | String   | Ex: "08:00 - 09:00"                          |
| valorPorHora | double   | Valor cobrado por esse horário               |
| disponivel   | boolean  | Indica se o horário está livre ou ocupado    |

---

### 📅 Aluguel

Registra cada locação realizada.

| Campo   | Tipo     | Descrição                                      |
|--------|----------|-----------------------------------------------|
| id     | int      | Identificador único do aluguel                |
| cliente| Cliente  | Cliente que realizou a reserva                |
| horario| Horario  | Horário reservado                            |
| data   | String   | Data no formato `dd/MM/yyyy`                 |
| valor  | double   | Valor total do aluguel                       |

---

## 📏 Regras de Negócio

- **RN01 — Nome obrigatório**  
  O cliente não pode ser cadastrado sem nome.

- **RN02 — Valor do horário válido**  
  O valor por hora deve ser maior que zero.

- **RN03 — Horário disponível**  
  Não é permitido reservar horários já ocupados.

- **RN04 — Cálculo automático**  
  O sistema soma automaticamente os aluguéis de um cliente no dia.

- **RN05 — Consulta por data**  
  Permite listar aluguéis de uma data específica.

- **RN06 — Telefone obrigatório**  
  O cliente deve informar um telefone válido.

---

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Separação de responsabilidades
- Padrão MVC (Model-View-Controller)
- Boas práticas de organização de código

---

## 👨‍💻 Autor
Desenvolvido por Alisson

## 📄 Licença
Este projeto é para fins acadêmicos e de aprendizado.

---
## 🏗️ Estrutura do Projeto


quadra-esportiva/

├── README.md

├── projeto1/ # Versão simples (sem MVC)

│ └── src/main/java/quadra/

│ ├── Cliente.java

│ ├── Horario.java

│ ├── Aluguel.java

│ ├── SistemaAluguel.java

│ └── Main.java


---
── projeto2/ # Versão com padrão MVC

└── src/main/java/quadra/

├── model/

│ ├── Cliente.java

│ ├── Horario.java

│ └── Aluguel.java

├── repository/

│ ├── ClienteRepository.java

│ ├── HorarioRepository.java

│ └── AluguelRepository.java

├── controller/

│ ├── ClienteController.java

│ ├── HorarioController.java

│ └── AluguelController.java

├── view/

│ └── SistemaView.java

└── Main.java

---

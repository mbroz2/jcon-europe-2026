# LangChain4j Agentic AI Workshop

Welcome to the LangChain4j Agentic AI Workshop!
This workshop will guide you through building **agentic systems** using Quarkus and LangChain4j.

You will learn how to:

- Implement AI agents with autonomous decision-making capabilities
- Build tools that agents can use to take actions
- Design agentic workflows to orchestrate multiple agents
- Use the supervisor pattern for dynamic orchestration
- Connect with remote agents using Agent-to-Agent (A2A) communication
- Implement human-in-the-loop patterns for critical decisions

---

## Workshop Scenario

Throughout the workshop, you will create an agentic system for a car rental company that autonomously processes returned vehicles.

The workshop consists of 5 progressive steps:

- **Step 1 – Implementing AI Agents:**
  Create your first autonomous agent that can make decisions and use tools.

- **Step 2 – Creating Simple Agentic Workflows:**
  Learn to orchestrate multiple agents in a sequential workflow.

- **Step 3 – Composing Multiple Agentic Workflows:**
  Build complex systems by composing multiple workflows together.

- **Step 4 – Supervisor Pattern for Dynamic Orchestration:**
  Implement a supervisor agent that dynamically routes work to specialized agents.

- **Step 5 – Using Remote Agents (A2A):**
  Connect to remote agents using the Agent-to-Agent protocol.

Each step builds on the previous one, with the results stored in separate directories (`step-XX`).

Final solution: `step-05`

---

## How to Work with Steps

!!! tip
    We recommend starting with the `main` branch, then opening the project from `step-01` in your IDE.
    If you prefer, you can make a copy of the directory instead.

!!! note
    To reset to a particular step, either overwrite your working directory with the content of that step,
    or open the project directly from the desired step directory.

---

![LangChain4j Agentic AI Workshop Architecture](images/global-architecture.png)

---

## Let's Get Started

First, check the [requirements](./requirements.md) page to prepare your environment.

Once ready, start with [Step 1 - Implementing AI Agents](./step-01.md).

---
toc: true
title: Análise de Desempenho
subtitle: EasyContext
author: Davi Tabosa
date: 2019
theme: Warsaw
colortheme: orchid
fontfamily: noto-sans
header-includes:
- \usepackage{cmbright}
fontsize: 10pt
---

# Sobre a análise

## Motivação
  - Mostrar o impacto do EasyContext em um aplicativo comum, comparando com sua versão sem o uso do framework
  - Mostrar os pontos fracos da abordagem atual

## Métricas 

  - Tamanho do aplicativo (kB)
  - Tempo de Inicialização (ms)

## Parâmetros

  - Número de Lembretes
  - Complexidade da regra contextual

## Fatores

  - 10 Lembretes com regras simples
  - 10 Lembretes com regras complexas

  Originalmente, os fatores eram 5 e 10 lembretes com regras simples e complexas, mas a quantidade de fatores foi reduzida.

## Carga de trabalho 

  Sistema Operacional Android 8.0 Oreo,  1GB de RAM, 16GB de armazenamento, processador Qualcomm Snapdragon 411 (MSM8917) 1.4 GHz Quad-Core.

# Metodologia

## Metodologia

  As medições foram realizadas em um hardware físico utilizando o Android Profiler. Para cada fator, foram realizadas dez medições nas duas versões do aplicativo, com e sem o framework.

  No Android Profiler, foi utilizado o recurso Method Trace, que mede o tempo de execução de cada método invocado pela aplicação.

## Exemplo de Method Trace

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/method-trace.png}
  \end{center}

# Resultados

## Resultados

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/builds.png}
  \end{center}

## Resultados

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/ec_single.png}
  \end{center}

## Resultados

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/ec_compound.png}
  \end{center}

## Resultados

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/normal_single.png}
  \end{center}

## Resultados

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/normal_compound.png}
  \end{center}

## Resultados

  \begin{center}
  \includegraphics[scale=0.3]{./imgs/media_tempos.png}
  \end{center}

# Conclusão

## A definição de inicialização satisfatória

  Segundo os Android Vitals, um aplicativo satisfatório deve inicializar nas seguintes situações:

  - Início Frio em 5 segundos ou menos.
  - Início Morno em 2 segundos ou menos.
  - Início Quente em 1.5 segundos ou menos.

## A definição de inicialização satisfatória

  O EasyContext no impacto da inicialização:

  |Tipo de inicialização | Impacto (%)  |
  |:-:|:-:|
  |Frio|12%|
  |Morno|26%|
  |Quente|-|

## Pontos fracos
  - Nas inicializações frias e mornas, o EasyContext sempre tenta ler o arquivo JSON e registrar os lembretes de acordo
  - Não possui um catálogo de regras registradas

## Usando o EasyContext

  - Não existe impacto significativo no tamanho do APK.
  - O tempo de inicialização aumentou drásticamente. (7x)
  - Regras complexas aumentam o tempo de execução, mas não linearmente.
  - Não é recomendado a utilização em aplicativos comerciais.

# Dificuldades

## Dificuldades

  - Construção dos aplicativos
  - O uso do Android Profiler
  - Obscuridade ao obter dados de memória
  - Tratamento de dados e geração de gráficos (outliers)

## Outliers
  \begin{center}
  \includegraphics[scale=0.3]{./imgs/ec_compound_outlier.png}
  \end{center}

## Outliers 

\begin{center}
  \includegraphics[scale=0.3]{./imgs/normal_compound_outlier.png}
  \end{center}

---
title: Análise de Desempenho
subtitle: EasyContext
author: Davi Tabosa
date: 2019
theme: Hannover
colortheme: orchid
fontfamily: noto-sans
header-includes:
- \usepackage{cmbright}
fontsize: 10pt
---

# Métricas
  - Tamanho do aplicativo (kB)
  - Tempo de Inicialização (ms)
# Parâmetros
  - Número de Lembretes
  - Complexidade da regra contextual

# Fatores
  - 10 Lembretes com regras simples
  - 10 Lembretes com regras complexas

  Originalmente, os fatores eram 5 e 10 lembretes, mas devido à metodologia utilizada, a quantidade de fatores foi reduzida.

# Carga de trabalho
  Sistema Operacional Android 8.0 Oreo,  2GB de RAM, 16GB de armazenamento, processador Qualcomm Snapdragon 425 (MSM8917) 1.4 GHz Quad-Core.

# Metodologia
  As medições foram realizadas em um hardware físico utilizando o Android Profiler. Para cada fator, foram realizadas dez medições nas duas versões do aplicativo, com e sem o framework.

  No Android Profiler, foi utilizado o recurso Method Trace, que mede o tempo de execução de cada método invocado pela aplicação.

## Exemplo de Method Trace
  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/method-trace.png}
  \end{center}

# Resultados
## Tamanho das builds
  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/builds.png}
  \end{center}
## Com EasyContext
  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/ec_single.png}
  \end{center}

  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/ec_compound.png}
  \end{center}
  
## Sem EasyContext
  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/normal_single.png}
  \end{center}

  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/normal_compound.png}
  \end{center}

## Media dos tempos de inicialização
  \begin{center}
  \includegraphics[width=0.4\textwidth]{./imgs/media_tempos.png}
  \end{center}
# Conclusão

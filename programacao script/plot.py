import numpy as np
from matplotlib import pyplot as plt
import csv

def remove_outliers(x, outlierConstant):
    a = np.array(x)
    upper_quartile = np.percentile(a, 75)
    lower_quartile = np.percentile(a, 25)
    IQR = (upper_quartile - lower_quartile) * outlierConstant
    quartileSet = (lower_quartile - IQR, upper_quartile + IQR)
    resultList = []
    for y in a.tolist():
        if y >= quartileSet[0] and y <= quartileSet[1]:
            resultList.append(y)
    return resultList

def divide10(v):
    return v/10

def plot_and_show(data, normal, title, outliers = False):
    no_outliers = remove_outliers(data, 1.5)
    normal_no_outliers = remove_outliers(normal, 1.5)
    percentile_chosen = [25, 50, 75]
    
    if(outliers):
        cdf = np.arange(1, len(data) + 1) /len(data)
        plt.plot(data, cdf, "bo-")    
        
    else:
        cdf = np.arange(1, len(no_outliers) + 1) /len(no_outliers)
        plt.plot(no_outliers, cdf, "bo-")    

    if(outliers):
        cdf = np.arange(1, len(normal) + 1) /len(normal)
        plt.plot(normal, cdf, "ro-")    
        
    else:
        cdf = np.arange(1, len(normal_no_outliers) + 1) /len(normal_no_outliers)
        plt.plot(normal_no_outliers, cdf, "ro-")
        
        
    
    plt.margins(0.02)
    plt.title(title)
    plt.xlabel("Tempo de execução (ms)")
    plt.ylabel("Porcentagem")
    plt.yticks(np.arange(0, 1.1, 0.1))



    plt.show()
    
    


ec_single = []
ec_compound = []
normal_single = []
normal_compound = []
with open("medicoes.csv") as medicoes_csv:
    csv_reader = csv.reader(medicoes_csv, delimiter=';')
    for row in csv_reader:
        ec_single.append(float(row[0]))
        ec_compound.append(float(row[1]))
        normal_single.append(float(row[2]))
        normal_compound.append(float(row[3]))


nomes = ("EasyContext", "Normal")
y_pos = np.arange(len(nomes))
values = [3180, 3088]


plt.bar(y_pos, values, 0.2)
plt.ylabel("Tamanho (kB)")
plt.xticks(y_pos, nomes)
plt.title("Build dos projetos")
plt.show()

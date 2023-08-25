import os

arq_name = "teste.txt"
pasta = ""
lista = []

def letra_no_fim(c1, c2):
    if not(c1 == "D") and not(c2 == "D"):
        return "D"
    elif not(c1 == "N") and not(c2 == "N"):
        return "N"
    elif not(c1 == "A") and not(c2 == "A"):
        return "A"
    
    return ""
    
def precisa_mudar(c1, c2):
    if (c1 == "D" and c2 == "N") or (c1 == "N" and c2 == "D") or (c1 == "A" and c2 == "N") or (c1 == "N" and c2 == "A") or (c1 == "D" and c2 == "A") or (c1 == "A" and c2 == "D"):
        return True
    else:
        return False

arq = open(os.path.join(pasta, arq_name), "r", encoding="utf-16")
data = arq.readlines()
data = data[0]



for d in data:
    lista.append(d)
    lista = [item.replace('\n', ' ') for item in lista]
    
count = 0
for char in lista:
    if char.isalpha():
            count = count + 1

print("\n=========================================================")
print(f"            DNA[{lista}] ")
print("            TAMANHO INICIAL: ", count)
print("=========================================================\n")

acha_dif = True
while True:
    if not acha_dif:
        break
    acha_dif = False
    for i in range(0, len(lista) - 1):
        j = i + 1

        if precisa_mudar(lista[i] ,lista[j]):
           novo = letra_no_fim(lista[i], lista[j])
           lista.pop(i)
           lista.pop(i)
           lista.append(novo)
           count = count - 1
           acha_dif = True
           print(lista)
           print("---------------")
           break

   

print("Resultado: ", lista)
print("Tamanho final: ",count)

        


/* 
 * File:   main.c
 * Author: Filipe Ribeiro
 *
 * Created on 1 de Maio de 2017, 1:02
 */

#include "aniareas.h"

/*
zone actualiza(zone v, char *nome, float *pesotototal, int *num, char *nomeadj, int * total) {
    int i;
    zone novo;

    for (i = 0; i< *total && strcmp(v[i].nome, nome) != 0; i++) {
        ;
    }
    novo = realloc(v, sizeof (zone)*(*total + 1));

    if (novo == NULL)
        return v;

    v = novo;

 *(total)++;

    strcpy(v[*total - 1].nome, nome);

    return v;



}
 */

int strcountc(char *s, char ch) {
    int i, conta;
    for (i = conta = 0; s[i] != '\0'; i++) {
        if (s[i] == ch) {
            conta++;
        }

    }
    return conta;
}

zone criavector(char *nomefich, int *total) {
    zone x = NULL;
    FILE *f;
    char nome[TAM];
    char nomeadj[TAM];
    float pesototal;
    *total = 0;
    int num = 0;

    f = fopen(nomefich, "rt");

    if (f == NULL) {
        printf("Erro ao abrir ficheiro %s \n", nomefich);
        return 0;
    }
    x = malloc(sizeof (areas));
    if (x == NULL) {
        printf("Erro a alocar memoria ");
        fclose(f);
        return 0;
    }
    int i = 0;
    int c;
    while (fscanf(f, " %s %f %d %[^\n]", nome, &pesototal, &num, nomeadj) == 4) {

        (*total)++;
        zone novo = x;
        novo = realloc(x, sizeof (areas)*(*total));
        if (novo == NULL) {
            printf("Erro na alocaçao de memoria \n");
            return x;
        }
        x = novo;

        strcpy(x[*total - 1].nome, nome);

        x[*total - 1].pesototal = pesototal;
        x[*total - 1].num = num;
        strcpy(x[*total - 1].nomeadj, nomeadj);
        x[*total - 1].anil = NULL;
    }

    for (int i = 0; i< *total; i++) {
        printf("%s %.2f %d %s \n ", x[i].nome, x[i].pesototal, x[i].num, x[i].nomeadj);
        c = strcountc(x[i].nomeadj, ' ');
        if (c == 0) {
            printf("\t\t\t%s %d \n", x[i].nomeadj, c);
            printf("\t\t\t 1 areas \n");
        } else
            if (c == 1) {
            printf("\t\t\t%s %d \n", x[i].nomeadj, c);
            printf(" \t\t\t2 areas\n");
        } else {
            printf("\t\t\t%s %d \n", x[i].nomeadj, c);
            printf("\t\t\t 3 areas \n");
        }
    }
    fclose(f);
    return x;
}

void adicionalocal(doge lista, zone x, int *total) {
    doge percorre = lista;
    doge aux;
    for (int i = 0; i < *total; i++) {

        for (percorre = lista; percorre; percorre = percorre->prox) {
            if (strcmp(percorre->local, x[i].nome) == 0) {

                if (x[i].anil == NULL) {
                    x[i].anil = percorre;
                    percorre->aran = NULL;
                } else {
                    aux = x[i].anil;
                    while (aux->aran != NULL) {
                        aux = aux->aran;
                    }
                    aux->aran = percorre;
                }

            }

        }
    }
}

zone trocareas(doge lista, zone x, int *total) {
    doge aux = lista;

    char resposta[TAM];
    char resposta2[TAM];

    FILE *f;

    f = fopen("animal.dat", "ab");

    printf("Introduza o nome do animal que deseja transferir : \n");
    scanf("%s", resposta);

    while (aux != NULL) {
       
        printf("Introduza area onde quer colocar o animal %s\n", resposta);
        scanf("%s", resposta2);

       
      

        for ( int i = 0 ; i <*total; i++)
        { 
            if (strcmp(x[i].nome, resposta2) != 0) {
            printf("Nao existe nenhuma area com esse nome %s", resposta2);
            return x;
           
        }
           
            for(int i = 0 ; i <*total ; i++)
            {
            if(x[i].nomeadj == resposta2 )
                strcpy(aux->local , resposta2);
            }
            aux= aux->prox;
  }
        return x;

    }








}

zone adicionarea(zone x, int *total) {
    zone aux;
    zone percorre;
    char nome[TAM];
    char adjc1[TAM];
    char adjc2[TAM];
    char adjc3[TAM];
    int peso = 0, num = 0;
    int i = 0, flag;

    percorre = x;

    aux = realloc(x, sizeof (areas)*(*total + 1));

    if (aux == NULL) {
        printf("Erro na realocaçao de memoria em adiciona area ");
        return x;
    }
    x = aux;
    (*total)++;


    printf("Introduza o nome da area : \n ");
    scanf("%s", nome);
    while (i < *total) {
        if (strcmp(percorre[i].nome, nome) == 0) {
            printf("ERRO\n");
            return 0;
        }
        i++;
    }

    printf("Introduza o peso total da area : \n");
    scanf("%d", &peso);
    printf("Introduza o numero das areas adjacentes : \n");
    scanf("%d", &num);

    if (num == 1) {
        printf("Introduza o nome da area adjacente \n");
        scanf("%s", adjc1);
    } else
        if (num == 2) {
        printf("Introduza o nome das 2 areas adjacentes : \n");
        scanf(" %[^\n]", adjc2);
    } else
        if (num == 3) {
        printf("Introduza o nome das 3 areas adjacentes :\n");
        scanf(" %[^\n] ", adjc3);
    }

    strcpy(x[*total - 1].nome, nome);
    x[*total - 1].pesototal = peso;
    x[*total - 1].num = num;


    if (x[*total - 1].num == 1) {
        strcpy(x[*total - 1].nomeadj, adjc1);
    } else
        if (x[*total - 1].num == 2) {
        strcpy(x[*total - 1].nomeadj, adjc2);
    } else
        if (x[*total - 1].num == 3) {
        strcpy(x[*total - 1].nomeadj, adjc3);
    }


    return x;
}

void mostrareastotal(zone x, int *total) {
    int i = 0;
    while (i< *total) {
        printf(" %s %.2f %d %s\n", x->nome, x->pesototal, x->num, x->nomeadj);
        i++;
        x++;
    }

}

void mostranimalarea(zone x, int *total) {
    char resp[TAM];
    doge aux;
    printf("Introduza a area a ser mostrada : \n ");
    scanf("%s", resp);

    int i = 0;


    while (i < *total) {
        if (strcmp(x[i].nome, resp) == 0) {
            aux = x[i].anil;
            while (aux != NULL) {

                printf("Especie %s\n", aux->especie);
                printf("Nome %s\n", aux->nome);
                printf("Peso %.2f \n", aux->peso);
                printf("Local %s\n\n", aux->local);
                aux = aux->aran;

            }
        }
        i++;
    }

}

/*------------------------------------------------------*/
doge listaligada(animal y, doge lista) {
    doge novo, aux;
    novo = (doge) malloc(sizeof (animal));
    if (!novo) {
        printf("Erro!");
        return lista;
    }

    strcpy(novo->especie, y.especie);
    strcpy(novo->local, y.local);
    novo->n_serie = y.n_serie;
    novo->peso = y.peso;
    strcpy(novo->nome, y.nome);
    novo->aran = NULL;

    novo->prox = NULL;
    {
        if (lista == NULL) {

            lista = novo;
            //lista->prox = NULL;
            return lista;
        } else {
            aux = lista;
            while (aux->prox != NULL) {
                aux = aux->prox;
            }
            aux->prox = novo;

        }

    }
    return lista;
}

doge constroi(char *a) {
    FILE *f;
    doge lista = NULL;
    animal x;
    f = fopen(a, "rb");
    if (f == NULL) {
        printf("Erro ao abrir ficheiro!**\n");
    }

    while (fread(&x, sizeof (animal), 1, f) == 1) {

        lista = listaligada(x, lista);



    }
    fclose(f);
    return lista;

}

doge adiciona(doge lista, zone x, int *total, char *nomefich) {

    FILE *f;
    doge aux;
    doge novo = malloc(sizeof (animal));
    char nome[TAM];
    char especie[TAM];
    float peso;
    char onde[TAM];

    f = fopen(nomefich, "rt");
    if (f == NULL) {
        printf("Erro a abrir ficheiro :%s \n", nomefich);
    }
    if (novo == NULL) {
        printf("Erro ao alocar memoria \n");
        return 0;
    }
    // fscanf(f, "Numero de animais : %d \n ", &numani);
    //printf("Numero de animais a ser adicionado %d", numani);
    // fscanf(f, " %s %s %f ", especie,nome, &peso);
    for (int i = 0; i < *total; i++) {
        x[i].pesototal2 = 0;
    }
    while (fscanf(f, " %s %s %f %[^\n]", especie, nome, &peso, onde) == 4) { // for (int i = 0; i < 4; i++) 
        // fscanf(f, " %s %s %f ", especie,nome, &peso);
        novo = (doge) malloc(sizeof (animal));
        if (novo == NULL) {
            printf("Erro na alocacao da memoria!\n");
        }


        strcpy(novo->especie, especie);
        strcpy(novo->nome, nome);

        novo->peso = peso;
        strcpy(novo->local, onde);
        for (int i = 0; i <*total; i++) {
            if (strcmp(novo->local, x[i].nome) == 0) {
                x[i].pesototal2 += peso;
                while (x[i].pesototal < x[i].pesototal2) {
                    printf("PESO EXCEDIDO \n");
                    return lista;
                }

                printf(" %s %.2f \n", x[i].nome, x[i].pesototal2);




            }
        }


        novo->prox = NULL;
        if (lista == NULL)
            lista = novo; /*primeiro*/
        else {
            aux = lista;
            while (aux -> prox != NULL)

                aux = aux->prox;

            aux->prox = novo;


        }



    }


    fclose(f);

    
}



void visualizar(doge lista) {
    FILE *g;
    doge bin = lista;

    g = fopen("animal.dat", "rb");

    if (g == NULL)
        printf("Erro  a abrir %s \n", "animal.dat");


    printf("Lista completa de animais : \n");
    //  exit(1);

    while (bin != NULL) {
        printf("Especie %s Nome:%s Peso:%.2f ; %s \n", bin->especie, bin->nome, bin->peso, bin->local);
        bin = bin->prox;
    }


    // i++;
    //printf("%s \n",bin->nome);

    fclose(g);
}

void listagemcompletanome(doge lista) {
    FILE *g;
    doge bin = lista;
    char resposta[TAM];


    g = fopen("animal.dat", "rb");

    if (g == NULL) {
        printf("Erro ao abrir %s ", "animal.dat");
    }

    printf("Introduza o nome do animal : \n");
    scanf("%s", resposta);
    while (bin != NULL) {
        if (strcmp(bin->nome, resposta) == 0) {
            printf("Especie: %s Nome:%s Peso: %.2f %s \n ", bin->especie, bin->nome, bin->peso, bin->local);

        }
        bin = bin->prox;
    }
    fclose(g);

}

void listagemcompletaespecie(doge lista) {
    FILE *g;
    doge bin = lista;
    char resposta[TAM];

    g = fopen("animal.dat", "rb");

    if (g == NULL) {
        printf("Erro ao abrir %s ", "animal.dat");
    }

    printf("Introduza a especie do animal : \n");
    scanf("%s", resposta);
    while (bin != NULL) {
        if (strcmp(bin->especie, resposta) == 0)

            printf("Especie :%s Nome:%s Peso :%.2f %s\n", bin->especie, bin->nome, bin->peso, bin->local);

        bin = bin->prox;
    }
    fclose(g);
}

doge remover(doge lista) {
    char nome[TAM];
    doge aux = lista, anterior = NULL;

    printf("Indique o nome do animal que quer eliminar:");
    scanf(" %s", nome);


    while (aux != NULL && strcmp(nome, aux->nome) != 0) {
        anterior = aux;
        aux = aux -> prox;
        /*procurar pelo nome do animal*/
    }
    if (aux == NULL) {
        printf("O animal introduzido nao consta na lista:");
        return lista;
    }
    if (anterior == NULL)
        lista = aux->prox;
    else
        anterior->prox = aux -> prox;
    free(aux);
    return lista;
}

int menu() {
    int num;

    printf("\n\n1- Novo animal");
    printf("\n2- Mostrar ");
    printf("\n3- Listagem ");
    printf("\n4-Eliminar");
    printf("\n5- Terminar");

    do {
        printf("\nEscolha uma opcao ; ");
        scanf(" %d", &num);
    } while (num < 1 || num > 6);
    return num;
}

int menu2() {
    int num;

    printf("\n\n1- Mostra Areas");
    printf("\n2- Adiciona Areas ");
    printf("\n3-  Eliminar Areas");
    printf("\n4- Terminar");

    do {
        printf("\nEscolha uma opcao ; ");
        scanf(" %d", &num);
    } while (num < 1 || num > 5);
    return num;

}

void guardareas(char *nomefich, zone x, int *total) {
    FILE *f;

    f = fopen(nomefich, "wt");

    if (f == NULL) {
        printf("Erro ao abrir ficheiro %s", nomefich);
        fclose(f);
        return;
    }

    for (int i = 0; i < *total; i++) {
        fprintf(f, " %s %.2f %d %s \n", x[i].nome, x[i].pesototal, x[i].num, x[i].nomeadj);

    }

    fclose(f);




}

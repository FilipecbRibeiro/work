/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatese
 * and open the template in the editor.
 */
#include "aniareas.h"

int main(int argc, char** argv) {


    int i, j;
    doge lista = NULL;
    doge aux;
    doge aux2;
    zone v = NULL;


    animal x;
    FILE *f, *g;
    int tam;
    v = criavector("areas.txt", &tam);

    if (v == NULL) {
        printf("erro");

    }
    if (v != NULL) {

    }
    lista = constroi("animal.dat");

  //  v= trocareas(lista , v, &tam);

    do {
        i = menu();
        switch (i) {
            case 1:
                lista = adiciona(lista, v, &tam, "adiciona.txt");


                break;
            case 2:
                visualizar(lista);
                break;
            case 3:
                listagemcompletanome(lista);
                listagemcompletaespecie(lista);
                break;
            case 4:

                lista = remover(lista);
                break;
            case 5:
                f = fopen("animal.dat", "wb");
                if (f == NULL) {
                    printf("ERRO AO ABRIR %s", "animal.dat");
                }

                aux = lista;


                while (aux != NULL) {
                    strcpy(x.especie, aux->especie);
                    strcpy(x.local, aux->local);

                    strcpy(x.nome, aux->nome);
                    x.peso = aux->peso;
                    x.n_serie = aux->n_serie;
                    x.prox = aux->prox;
                    fwrite(&x, sizeof (animal), 1, f);

                    aux = aux->prox;
                }
                /*
                                aux2 = lista; 
                                while( lista != NULL)
                                {
                                    aux2 = aux2->prox;
                                    free(lista) ;
                    
                                    lista = aux2 ;
                           
                   
                                } 
                    
                 */
                fclose(f);

                break;

        }
    } while (i != 5);
    do {
        j = menu2();
        switch (j) {
            case 1:
                adicionalocal(lista, v, &tam);
                mostrareastotal(v, &tam);
                mostranimalarea(v, &tam);
                break;
            case 2:
              v=  adicionarea(v, &tam);
                break;
            case 3:

                break;
            case 4:
                guardareas("areas.txt", v, &tam);

                return 0;

        }
    } while (i != 4);
    system("PAUSE");
    return (EXIT_SUCCESS);
}


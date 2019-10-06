/* 
 * File:   main.c
 * Author: Asus
 *
 * Created on 18 de Outubro de 2018, 16:53
 */
#include "tabuleiro.h"

puz fillboard(puz *a)
 {

    int conta = 1;
    int i = 0;
    int j = 0;
    for (int k = 0; k < TAM; k++)
        for (int h = 0; h < TAM; h++) {
            a->tabuleiro[k][h] = 0;
            a->goal[h][k] = 0;
            a->h2[h][k] = 0;
        }
    a->positionvoidx = 0;
    a->positionvoidy = 0;
    a->id = 0;
    a->h1 = 0;
    a->totalh2 = 0;
    a->position = 0;

    for (i = 0; i < TAM; i++) {
        for (j = 0; j < TAM; j++) {


            a->tabuleiro[i][j] = conta;
            a->goal[i][j] = conta;
            conta++;
            if (conta == 10) {
                a->tabuleiro[i][j] = 0;
                a->goal[i][j] = 0;
                a->positionvoidx = i;
                a->positionvoidy = j;
            }
        }
    }
    //

    return *a;
}

void calculah2total(puz *a) {
    int num = 0;
    a->totalh2 = 0;
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {

            {
                num += a->h2[i][j];

                //printf("%d ",num);
            }
        }
    }
    a->totalh2 = num;
    // printf("sem sombras %d\n",num);
    //  return num;
}

puz acontecejogada0paradireita(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y + 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y + 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y + 1;


        return *temp;
    }
    return *a;
}

puz acontecejogada0parabaixo(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}
/////////////////////////////////////////////////////

puz acontecejogada1paradireita(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada1parabaixo(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada1paraesquerda(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y - 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y - 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y - 1;


        return *temp;
    }
    return *a;
}


///////////////////////////////////////////////////////

puz acontecejogada2paraesquerda(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y - 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y - 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y - 1;


        return *temp;
    }
    return *a;
}

puz acontecejogada2parabaixo(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 0 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}


///////////////////////////////////////////////////////

puz acontecejogada3paracima(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x - 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x - 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x - 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada3paradireita(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y + 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y + 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y + 1;


        return *temp;
    }
    return *a;
}

puz acontecejogada3parabaixo(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}


//////////////////////////////////////////////////////////////////////

puz acontecejogada4paracima(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x - 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x - 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x - 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada4parabaixo(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada4paradireita(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y + 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y + 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y + 1;


        return *temp;
    }
    return *a;
}

puz acontecejogada4paraesquerda(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y - 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y - 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y - 1;


        return *temp;
    }
    return *a;
}

///////////////////////////////////////////////

puz acontecejogada5paraesquerda(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y - 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y - 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y - 1;


        return *temp;
    }
    return *a;
}

puz acontecejogada5paracima(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x - 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x - 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x - 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada5parabaixo(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 1 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x + 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x + 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x + 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}



//////////////////////////////////////////////////////

puz acontecejogada6paracima(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x - 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x - 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x - 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada6paradireita(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 0) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y + 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y + 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y + 1;


        return *temp;
    }
    return *a;
}

/////////////////////////////////////////////////////////

puz acontecejogada7paracima(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x - 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x - 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x - 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada7paradireita(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y + 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y + 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y + 1;


        return *temp;
    }
    return *a;
}

puz acontecejogada7paraesquerda(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 1) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y - 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y - 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y - 1;


        return *temp;
    }
    return *a;
}
//////////////////////////////////////

puz acontecejogada8paracima(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x - 1][y]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x - 1][y] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x - 1;
        temp->positionvoidy = y;


        return *temp;
    }
    return *a;
}

puz acontecejogada8paraesquerda(puz *a)

 {
    int x = a->positionvoidx;
    int y = a->positionvoidy;
    puz *temp = a;
    int aux = 0;
    if (x == 2 && y == 2) {
        aux = temp->tabuleiro[x][y]; //guarda o numero da posicao do 0
        temp->tabuleiro[x][y] = temp->tabuleiro[x][y - 1]; //poe no lugar do 0 a casa a direita
        temp->tabuleiro[x][y - 1] = aux; //poe no lugar do numero a direita o valor 0;
        temp->positionvoidx = x;
        temp->positionvoidy = y - 1;


        return *temp;
    }
    return *a;
}

int descobremin(puz *a) {
  /*  if (a->totalh2 > a->h1) {
        return a->h1;
    } else*/
        return a->totalh2;
}

int findposition(puz *a) {
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            if (a->positionvoidx == 0 && a->positionvoidy == 0) {
                a->position = 0;
            }
            if (a->positionvoidx == 0 && a->positionvoidy == 1) {
                a->position = 1;
            }
            if (a->positionvoidx == 0 && a->positionvoidy == 2) {
                a->position = 2;
            }
            if (a->positionvoidx == 1 && a->positionvoidy == 0) {
                a->position = 3;
            }
            if (a->positionvoidx == 1 && a->positionvoidy == 1) {
                a->position = 4;
            }
            if (a->positionvoidx == 1 && a->positionvoidy == 2) {
                a->position = 5;
            }
            if (a->positionvoidx == 2 && a->positionvoidy == 0) {
                a->position = 6;
            }
            if (a->positionvoidx == 2 && a->positionvoidy == 1) {
                a->position = 7;
            }
            if (a->positionvoidx == 2 && a->positionvoidy == 2) {
                a->position = 8;
            }
        }
    }
    return a->position;
}

puz fazjogada(puz* a) {

}

int randompara0268() {
    int num = 0;


    num = rand() % 2 + 1;

    //printf("numero que saiu foi %d\n",num);
    return num;
}

int randompara4() {
    int num = 0;


    num = rand() % 4 + 1;

    //printf("numero que saiu foi %d\n",num);
    return num;
}

int randompara1357() {
    int num = 0;


    num = rand() % 3 + 1;

    //printf("numero que saiu foi %d\n",num);
    return num;
}

puz shuffleboard(puz *a) {
    int temp = 0;
    int randomIndex = 0;
    int randomIndex2 = 0;
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            temp = a->tabuleiro[i][j];
            randomIndex = rand() % 2;
            randomIndex2 = rand() % 2;

            a->tabuleiro[i][j] = a->tabuleiro[randomIndex2][randomIndex];
            a->tabuleiro[randomIndex2][randomIndex] = temp;

        }

    }
    for (int i = 0; i < TAM; i++)
        for (int j = 0; j < TAM; j++)
            if (a->tabuleiro[i][j] == 0) {
                a->positionvoidx = i;
                a->positionvoidy = j;
            }

    return *a;
}

puz comparegoal(puz *a, int num, int posx, int posy) {
    int j = 0;
    int k = 0;
    int countlinecolumn1 = 0;
    int goalx = 0;
    int goaly = 0;
    int difx = 0;
    int dify = 0;
    int total = 0;
    if (num != 0) {
        for (int i = 0; i < TAM; i++)
            for (int j = 0; j < TAM; j++) {
                if (a->goal[i][j] == num) {
                    goalx = i;
                    goaly = j;
                }
            }
        difx = abs(posx - goalx);
        dify = abs(posy - goaly);

        total = difx + dify;

        for (int k = 0; k < TAM; k++) {
            for (int h = 0; h < TAM; h++) {
                if (a->goal[k][h] == num)

                    a->h2[k][h] = total;
            }
        }
    } 

    return *a;


}

puz verificah2(puz *a) {
    int position = 0;
    int posx = 0;
    int posy = 0;
    int i = 0;
    int j = 0;

    for (i = 0; i < TAM; i++)
        for (j = 0; j < TAM; j++) {
            posx = i;
            posy = j;

            comparegoal(a, a->tabuleiro[i][j], posx, posy);

        }
    return *a;
}

puz verificah1(puz* a) {
    a->h1 = 0;

    for (int i = 0; i < TAM; i++)
        for (int j = 0; j < TAM; j++) {
            if ((a->tabuleiro[i][j] != a->goal[i][j]) && a->tabuleiro[i][j] != 0) {

                a->h1 += 1;
            }

        }
    //printf("FORA DO SITIO %d\n",a->h1);
    return *a;
}

next add(next lista, puz a) {


    int s = 0;
    s = verificaseestadopresente(lista, &a);
    //printf("s ->%d",s);
   if(s==1){
        next aux;
        next new = malloc(sizeof (puz));

        int i = 0;
        int j = 0;

        if (new == NULL) {
            printf("Error allocating memory");
            return 0;
        }
        for (i = 0; i < TAM; i++)
            for (j = 0; j < TAM; j++) {
                new->tabuleiro[i][j] = a.tabuleiro[i][j];
                new->goal[i][j] = a.goal[i][j];
                new->h2[i][j] = a.h2[i][j];

                //       printf("%d",new->tabuleiro[i][j]);
            }

        new->positionvoidx = a.positionvoidx;
        // printf("%d\n",a.h1);
        new->h1 = a.h1;
        new->totalh2 = a.totalh2;
        new->positionvoidy = a.positionvoidy;
        new->position = a.position;
        new->id = a.id;
        //  printf("[%d][%d] ", new->positionvoidx,new->positionvoidy);
        new->prox = NULL;

        if (lista == NULL)
            lista = new; /*first*/
        else {
            aux = lista;
            while (aux->prox != NULL)

                aux = aux->prox;

            aux->prox = new;
        }
        // printf("sai do add\n");
}
    return lista;

}

puz buscaultimoadicionado(next lista) {
    next aux = lista;
    puz *temp;
    while (aux != NULL) {
        if (aux->prox == NULL) {
            temp = aux;
            return *temp;
        }
        aux = aux->prox;
    }
}

int verificaseestadopresente(next lista, puz *a) {
    next aux = lista;
   int count=0;
    while (aux != NULL) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (a->tabuleiro[i][j] == aux->tabuleiro[i][j]) {

                    
                    count++;

                }
            }
        }
         if(count==9)
        {
            printf("Iguais! %d\n",count);
          return 0;
        }
        count=0 ;
        
          aux = aux->prox;
          }
     
     /*   while (aux != NULL) {
         for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
            
               if (j == 0)
                    printf("|");
                if (aux->tabuleiro[i][j] == 0)
                    printf("  |");

                if (aux->tabuleiro[i][j] != 0)

                    printf("%d |", aux->tabuleiro[i][j]);


                if (j == 2)
                    putchar('\n');



            }

        }

        putchar('\n');
            
              aux = aux->prox;
         }
       */ 
       /* 
         for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                
             if (j == 0)
                    printf("|");
                if (a->tabuleiro[i][j] == 0)
                    printf("  |");

                if (a->tabuleiro[i][j] != 0)

                    printf("%d |", a->tabuleiro[i][j]);


                if (j == 2)
                    putchar('\n');
            }
            
            }
      */
        fflush(stdout);
      //  getchar();
      //  getchar();
        
       
       
    

    return 1;
}

void listcompleteofboards(next lista) {
    next aux = lista;

    while (aux != NULL) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (j == 0)
                    printf("|");
                if (aux->tabuleiro[i][j] == 0)
                    printf("  |");

                if (aux->tabuleiro[i][j] != 0)

                    printf("%d |", aux->tabuleiro[i][j]);


                if (j == 2)
                    putchar('\n');



            }

        }

        putchar('\n');


        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {


                printf("%d", aux->h2[i][j]);


                if (j == 2)
                    putchar('\n');



            }

        }
        printf("Posicao actual---> [%d][%d]\n", aux->positionvoidx, aux->positionvoidy);
        printf("Number of square in the wrong position %d\n", aux->h1);
        aux = aux->prox;
        putchar('\n');
    }
    printf("sai da listagem");

}


/* 
 * File:   tabuleiro.h
 * Author: Asus
 *
 * Created on 18 de Outubro de 2018, 16:54
 */



#include <stdio.h>
#include <stdlib.h>
#include <stdlib.h> 
#include <time.h> 
  

#define TAM 3




typedef struct puzzle puz, *next;

struct puzzle
{
    int tabuleiro[TAM][TAM];
    int h2[TAM][TAM];
    int h1;
    int id ;
    int totalh2;
    
    int positionvoidx;
    int positionvoidy;
    int position;
    next prox;
    int goal [TAM][TAM];
};




puz fillboard(puz *a);

next add (next lista,puz a);
puz verificah1(puz* a);
puz shuffleboard ( puz *b);
puz comparegoal(puz *a , int num,int posx,int posy);
puz verificah2(puz *a);
next add (next lista,puz a);
void listcompleteofboards(next lista);
int comparagoal(puz *a, int valor);
puz verificah2(puz *a);
void  calculah2total(puz *a);
int verificaseestadopresente(next lista,puz *a);


puz fazteste(puz *a);
puz fazjogada(puz *a);
puz acontecejogada0paradireita(puz *a);
puz acontecejogada0parabaixo(puz *a);
puz acontecejogada1paradireita(puz *a);
puz acontecejogada1parabaixo(puz *a);
puz acontecejogada1paraesquerda(puz *a);
puz acontecejogada2parabaixo(puz *a);
puz acontecejogada2paraesquerda(puz *a);
puz acontecejogada3paracima(puz *a);
puz acontecejogada3paradireita(puz *a);
puz acontecejogada3parabaixo(puz *a);
puz acontecejogada4parabaixo(puz *a);
puz acontecejogada4paracima(puz *a);
puz acontecejogada4paraesquerda(puz *a);
puz acontecejogada4paradireita(puz *a);
puz acontecejogada5parabaixo(puz *a);
puz acontecejogada5paracima(puz *a);
puz acontecejogada5paraesquerda(puz *a);
puz acontecejogada6paradireita(puz *a);
puz acontecejogada6paracima(puz *a);
puz acontecejogada7paradireita(puz *a);
puz acontecejogada7paracima(puz *a);
puz acontecejogada7paraesquerda(puz *a);
puz acontecejogada8paracima(puz *a);
puz acontecejogada8paraesquerda(puz *a);
int descobremin(puz *a);
int findposition(puz *a);
int randompara0268 ();
int randompara1357 ();
int randompara4();
puz buscaultimoadicionado(next lista);


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   aniareas.h
 * Author: Filipe
 *
 * Created on 21 de Maio de 2017, 22:51
 */


#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#define TAM 50

typedef struct animais animal, *doge;
typedef struct area areas, *zone;
	
struct animais {
    char local[TAM]; /*localizaçao de cada animal nas respectivas areas */
    char especie[TAM]; /*Identificador unico comum a animais da mesma especie*/
    int n_serie; /*identificador unico a cada animal dentro da especie */
    float peso;
    char nome[TAM];
    doge prox;
    doge aran;

};

struct area {
    char nome[TAM];
    float pesototal;
    float pesototal2;
    char nomeadj[TAM];
    int num;
    doge anil;

};

//void mostra_animais(char *nomefich);
//void mostra_areas(char *nomefich);
int strcountc(char *s, char ch);
zone criavector(char *nomefich, int *total);
void adicionalocal(doge lista, zone x, int *total);
zone adicionarea(zone x, int *total);
void mostrareastotal(zone x, int *total);
void mostranimalarea(zone x, int *total);
doge listaligada(animal y, doge lista);
doge constroi(char *a);
doge adiciona(doge lista, zone x, int *total, char *nomefich);
void visualizar(doge lista);
void listagemcompletanome(doge lista);
void listagemcompletaespecie(doge lista);
doge remover(doge lista);
void guardareas(char *nomefich, zone x, int *total);
zone trocareas(doge lista, zone x, int *total);
int menu();
int menu2();
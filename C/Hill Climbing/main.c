




#include "tabuleiro.h"

int main()


{

     
            
   srand(time(0)); 
    puz b;
    puz a;
    puz c;
    next lista = NULL;
    int total= 0;
    int aux= 0 ; 
    int um=0;
    int dois=0;
    int tres=0 ;
    int quatro=0;
    int count =0 ;
    int testerandom = 0 ;
    int minimo = 0 ;
    int minimo2 =0;
    int minimo3 =0 ;
    int minimo4 = 0 ; 
    int minimoreal = 0 ;
    puz f;
    b= fillboard(&b); 
    //lista= add(lista,b);
   // int teste2random=2;
    puz d;
    puz e;
 //   do{
       
    b=  shuffleboard (&b);
  //  }
   //while(b.tabuleiro[1][]!= 0);
    b = verificah1(&b);
    b= verificah2(&b);
    calculah2total(&b);
    lista= add(lista,b);
    minimoreal= descobremin(&b);
    //printf("MinimoReal %d\n",minimoreal);
    int s=0;
    do{
    int num = findposition(&b);
    
    switch (num){
            case 0:
                 um= 0 ; 
                dois = 0 ;
                s=0;
             
                do {        
                    testerandom= 0 ; 
                    testerandom=  randompara0268();
                    a=buscaultimoadicionado(lista);
                    c=buscaultimoadicionado(lista);
               // d=buscaultimoadicionado(lista);
                if(testerandom ==1 && um ==0){
             //  printf("SAIU  UM\n");
                 a=  acontecejogada0parabaixo(&a);
                 
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
            //    printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
               //       printf("Estou aqui minimo%d\n");
                  
                     lista=add(lista,a);
                    
                      aux=1;
                     dois= 1;
                    
                     
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
            //     printf("SAIU  DOIS\n");
                 c= acontecejogada0paradireita(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
            //    printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
              //     printf("Estou aqui minimo2 %d\n");
                   
               
                      lista=add(lista,c);
                  
                   
                     
                           aux=1;
                     um=1;
                     
                     }
                     
                 }
               
                
                
             
              
               // 
                }while( aux==0||( um ==0 && dois==0));
                   b= buscaultimoadicionado(lista);
                  // printf("Count \t\t\t--->  %d",count);
                   count++;
                   break;
            case 1:
                a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
                d=buscaultimoadicionado(lista);
                       
                           um= 0 ; 
                dois = 0 ;
                tres= 0;
               //    a=buscaultimoadicionado(lista);
                //c=buscaultimoadicionado(lista);
                //d= buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=    randompara1357();
                if(testerandom ==1 && um ==0){
            //   printf("SAIU  UM\n");
                 a=  acontecejogada1parabaixo(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
           //     printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
         //             printf("Estou aqui minimo%d\n");
                  
                     lista=add(lista,a);
                   
                       aux=1;
                     dois =1;
                     tres=1;
                     
                
                 }
                
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
              //   printf("SAIU  DOIS\n");
                 c= acontecejogada1paradireita(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
          //      printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
                //   printf("Estou aqui minimo2 %d\n");
                
                   lista=add(lista,c);
                    
                      aux=1;
                     um = 1;
                     tres=1;
                     
                  
                 }
              } else
             if(testerandom ==3 && tres== 0)
             { 
              //   printf("SAIU  TRES\n");
                 d= acontecejogada1paraesquerda(&d);
                 d=verificah1(&d);
                 d=verificah2(&d);
                 calculah2total(&d);
                 tres=1;
                
                 minimo3= descobremin(&d);
                //("Minimo3 %d\n",minimo3); 
          
               if(minimo3 <=minimoreal)
                 {  
                //   printf("Estou aqui minimo2 %d\n");
                
                   lista=add(lista,d);
                  
                      aux=1;
                     dois=1;
                    um=1;
                     
                 
                 }
              } 
                
                
           
                
              
                }while(aux==0 ||( um ==0 && dois==0 && tres==0 ));
                 count++;
              //   printf("Count \t\t\t--->  %d",count);
                b= buscaultimoadicionado(lista);
                  break;
            case 2:
                    um= 0 ; 
                dois = 0 ;
                a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
              //  d=buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=   randompara0268();
                if(testerandom ==1 && um ==0){
               //printf("SAIU  UM\n");
                 a=  acontecejogada2parabaixo(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
                //printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
                     // printf("Estou aqui minimo%d\n");
                
                     lista=add(lista,a);
                
                     aux=1;
                     dois=1;
                     
                   
                  
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
                // printf("SAIU  DOIS\n");
                 c= acontecejogada2paraesquerda(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
              //  printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
          //         printf("Estou aqui minimo2 %d\n");
               
                   lista=add(lista,c);
                  
                      aux=1;
                      um=1;
                     
                
                 }
              } 
                
                
       
               //  saiu2=1;
             //   printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
             //   printf("Count : %d\n",count);
              //  
                }while(( um ==0 || dois==0));
             
                b= buscaultimoadicionado(lista);
              //  printf("Count \t\t\t--->  %d",count);
                   count++;
                  break;
            case 3:
                   a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
                d=buscaultimoadicionado(lista);
                       
                           um= 0 ; 
                dois = 0 ;
                tres= 0;
               //    a=buscaultimoadicionado(lista);
                //c=buscaultimoadicionado(lista);
                //d= buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=    randompara1357();
                if(testerandom ==1 && um ==0){
             //  printf("SAIU  UM\n");
                 a=  acontecejogada3parabaixo(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
              //  printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
           //           printf("Estou aqui minimo%d\n");
                  
                     lista=add(lista,a);
                   
                             aux=1;
                     dois=1;
                     tres=1;
                     
            
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
               //  printf("SAIU  DOIS\n");
                 c= acontecejogada3paradireita(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
             //   printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
               //    printf("Estou aqui minimo2 %d\n");
               
                   lista=add(lista,c);
                  
                  aux=1;
                     um=1;
                     tres=1;
                     
                   
                 }
              } else
                     if(testerandom ==3 && tres== 0)
             { 
          //       printf("SAIU  TRES\n");
                 d= acontecejogada3paracima(&d);
                 d=verificah1(&d);
                 d=verificah2(&d);
                 calculah2total(&d);
                 tres=1;
                
                 minimo3= descobremin(&d);
               // printf("Minimo3 %d\n",minimo3); 
          
               if(minimo3 <=minimoreal)
                 {  
                //   printf("Estou aqui minimo2 %d\n");
               
                   lista=add(lista,d);
                
                       aux=1;
                     dois=1;
                     um=1;
                     
                   
                 }
              } 
                
                
               
       
               //  saiu2=1;
          //      printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
            //    printf("Count : %d\n",count);
            //   
                }while(aux= 0||( um ==0 && dois==0 && tres==0 ));
                   b= buscaultimoadicionado(lista);
                  // printf("Count \t\t\t--->  %d",count);
                      count++;
                   break;
            case 4:
                   a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
                d=buscaultimoadicionado(lista);
                     e= buscaultimoadicionado(lista);  
                           um= 0 ; 
                dois = 0 ;
                tres= 0;
                quatro=0;
               //    a=buscaultimoadicionado(lista);
                //c=buscaultimoadicionado(lista);
                //d= buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=    randompara4();
                if(testerandom ==1 && um ==0){
           //    printf("SAIU  UM\n");
                 a=  acontecejogada4parabaixo(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
          //      printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
            //          printf("Estou aqui minimo%d\n");
                   
                     lista=add(lista,a);
                     
                     aux=1;
                     dois=1;
                     tres=1;
                     quatro=1;
                     
                  
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
             //    printf("SAIU  DOIS\n");
                 c= acontecejogada4paradireita(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
            //    printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
         //          printf("Estou aqui minimo2 %d\n");
               
                   lista=add(lista,c);
                  
                  aux=1;
                     um=1;
                     tres=1;
                     quatro=1;
                     
                   
                 }
              } else
                if(testerandom ==3 && tres== 0)
             { 
                // printf("SAIU  TRES\n");
                 d= acontecejogada4paraesquerda(&d);
                 d=verificah1(&d);
                 d=verificah2(&d);
                 calculah2total(&d);
                 tres=1;
                
                 minimo3= descobremin(&d);
              //  printf("Minimo3 %d\n",minimo3); 
          
               if(minimo3 <=minimoreal)
                   
                 {  
              //     printf("Estou aqui minimo3 %d\n");
                  
                   lista=add(lista,d);
                
                     aux=1;
                     dois=1;
                     quatro=1;
                     um=1;
                     
                  
                 }
                
                
              } else
            if(testerandom ==4 && quatro== 0)
             { 
            //     printf("SAIU  quatro\n");
                 e= acontecejogada4paracima(&e);
                 e=verificah1(&e);
                 e=verificah2(&e);
                 calculah2total(&e);
                 quatro=1;
                
                 minimo4= descobremin(&e);
             //   printf("Minimo4 %d\n",minimo4); 
          
               if(minimo4 <=minimoreal)
                 {  
                //   printf("Estou aqui minimo4 %d\n");
                
                   lista=add(lista,e);
                 
                   
                     
                   aux=1;
                     dois=1;
                     tres=1;
                     um=1;
                     
                   
                 }
              }   
             
               //  saiu2=1;
             //   printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
               // printf("Count : %d\n",count);
              //  
                }while(aux==0||( um ==0 && dois==0 && tres==0 &&quatro ==0));
                   b= buscaultimoadicionado(lista);
                //   printf("Count \t\t\t--->  %d",count);
                      count++;
                           break;
            case 5:
                   a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
                d=buscaultimoadicionado(lista);
                       
                           um= 0 ; 
                dois = 0 ;
                tres= 0;
               //    a=buscaultimoadicionado(lista);
                //c=buscaultimoadicionado(lista);
                //d= buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=    randompara1357();
                if(testerandom ==1 && um ==0){
               //printf("SAIU  UM\n");
                 a=  acontecejogada5parabaixo(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
             //   printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
                //      printf("Estou aqui minimo%d\n");
                  
                     lista=add(lista,a);
                    
                    
                     aux=1;
                     dois=1;
                     tres=1;
                     
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
            //     printf("SAIU  DOIS\n");
                 c= acontecejogada5paraesquerda(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
              //  printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
           //        printf("Estou aqui minimo2 %d\n");
               
                   lista=add(lista,c);
                  
                     aux=1;
                     tres=1;
                     um=1;
                     
                    
                 }
              } else
                     if(testerandom ==3 && tres== 0)
             { 
             //    printf("SAIU  TRES\n");
                 d= acontecejogada5paracima(&d);
                 d=verificah1(&d);
                 d=verificah2(&d);
                 calculah2total(&d);
                 tres=1;
                
                 minimo3= descobremin(&d);
               // printf("Minimo3 %d\n",minimo3); 
          
               if(minimo3 <=minimoreal)
                 {  
                 //  printf("Estou aqui minimo2 %d\n");
                   
                   lista=add(lista,d);
                   
                    aux=1;
                     dois=1;
                     um=1;
                     
                    
                 }
              } 
                
                
               
             
               //  saiu2=1;
            //    printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
      //          printf("Count : %d\n",count);
              //  
                }while(aux==0||( um ==0 && dois==0 && tres==0 ));
                   b= buscaultimoadicionado(lista);
                //   printf("Count \t\t\t--->  %d",count);
                      count++;
                   break;
            case 6:
                a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
          //      d=buscaultimoadicionado(lista);
                um= 0 ; 
                dois = 0 ;
                do {        
                    testerandom= 0 ; 
                    testerandom=   randompara0268();
                if(testerandom ==1 && um ==0){
              // printf("SAIU  UM\n");
                 a=  acontecejogada6paracima(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
             //   printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
           //           printf("Estou aqui minimo%d\n");
                     
                     lista=add(lista,a);
                   
                     aux=1;
                     dois=1;
                     
                   
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
              //   printf("SAIU  DOIS\n");
                 c= acontecejogada6paradireita(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
         //       printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
           //        printf("Estou aqui minimo2 %d\n");
                 
                   lista=add(lista,c);
                    
                  
                      aux=1;
                     um=1;
                     
                 
                 }
              } 
                
                
               
             
               //  saiu2=1;
             //   printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
        //        printf("Count : %d\n",count);
                //
                }while(aux==0||( um ==0 && dois==0));
                
                b= buscaultimoadicionado(lista);
            //    printf("Count \t\t\t--->  %d",count);
                   count++;
                  break;
            case 7:
                   a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
                d=buscaultimoadicionado(lista);
                       
                           um= 0 ; 
                dois = 0 ;
                tres= 0;
               //    a=buscaultimoadicionado(lista);
                //c=buscaultimoadicionado(lista);
                //d= buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=    randompara1357();
                if(testerandom ==1 && um ==0){
            //   printf("SAIU  UM\n");
                 a=  acontecejogada7paracima(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
            //    printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
           //           printf("Estou aqui minimo%d\n");
                   
                     lista=add(lista,a);
                   
                    
                            aux=1;
                     dois=1;
                     tres=1;
                    
                     
            
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
          //       printf("SAIU  DOIS\n");
                 c= acontecejogada1paradireita(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
          //      printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
            //       printf("Estou aqui minimo2 %d\n");
              
                   lista=add(lista,c);
              
                      
                        aux=1;
                     tres=1;
                     um=1;
                   
                 }
              } else
                     if(testerandom ==3 && tres== 0)
             { 
              //   printf("SAIU  TRES\n");
                 d= acontecejogada1paraesquerda(&d);
                 d=verificah1(&d);
                 d=verificah2(&d);
                 calculah2total(&d);
                 tres=1;
                
                 minimo3= descobremin(&d);
         //       printf("Minimo3 %d\n",minimo3); 
          
               if(minimo3 <=minimoreal)
                 {  
     //              printf("Estou aqui minimo2 %d\n");
                   
             
                   lista=add(lista,d);
                    
                   
                    aux=1;
                     um=1;
                     dois=1;
                     
                 }
              } 
                
                
               
            
               //  saiu2=1;
           //     printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
             //   printf("Count : %d\n",count);
            //    
                }while(aux==0 ||( um ==0 && dois==0 && tres==0 ));
              //  printf("Count \t\t\t--->  %d",count);
                   b= buscaultimoadicionado(lista);
                      count++;
                  break;
            case 8:
                um  = 0; 
                dois = 0 ;
                  
                
           a=buscaultimoadicionado(lista);
                c=buscaultimoadicionado(lista);
                d=buscaultimoadicionado(lista);
                do {        
                    testerandom= 0 ; 
                    testerandom=   randompara0268();
                if(testerandom ==1 && um ==0){
           //    printf("SAIU  UM\n");
                 a=  acontecejogada8paracima(&a);
                 a= verificah1(&a);
                 a=verificah2(&a);
                   calculah2total(&a);
                 minimo =descobremin(&a);
             //   printf("Minimo %d\n",minimo);
                um = 1;
                 if(minimo <=minimoreal)
                 {
               //       printf("Estou aqui minimo%d\n");
                  
                     lista=add(lista,a);
                   
                      
                     aux=1;
                     dois=1;
                     
                 }
                            
             //    saiu1=1;
             }else
             if(testerandom ==2 && dois==0)
             { 
                 //printf("SAIU  DOIS\n");
                 c= acontecejogada8paraesquerda(&c);
                 c=verificah1(&c);
                 c=verificah2(&c);
                 calculah2total(&c);
                 dois=1;
                
                 minimo2= descobremin(&c);
                //printf("Minimo2 %d\n",minimo2); 
          
               if(minimo2 <=minimoreal)
                 {  
                //   printf("Estou aqui minimo2 %d\n");
                  
                   
                   lista=add(lista,c);
                   
                     
                      
                     aux=1;
                     um=1;
                     
                 }
              } 
                
                
               
            
            //    printf("AUX-> %d\n, Um -> %d\n,Dois->%d\n",aux,um,dois);
               // printf("Count : %d\n",count);
              //  
                }while(aux ==0 || ( um ==0 &&dois==0));  
            //    printf("Count \t\t\t--->  %d",count);
                count++;
                   b= buscaultimoadicionado(lista);
                   
                    
              
                
              break;  
    }
    if(count==100)
    {
        count =0 ; 
        b= shuffleboard(&b);
        lista=add(lista,b);
    //    b=verificah1(&b);
      //  b=verificah2(&b);
       // calculah2total(&b);
       
    }
   
   }while(b.h1 >=4);
//  while(b.h1!=0|| count<100);
     /*  b= verificah2(&b);
    b=verificah1(&b);
    descobreposicao = findposition(&b);
    printf("POSICAO UM -----> %d\n\n",descobreposicao);
    total2= calculah2total(&b);
    lista=add(lista,b);
    printf("o h2 deu %d\n",b.totalh2);
    a=b;
    a=acontecejogada8paracima(&a);
    lista=add(lista,a);
    descobreposicao = findposition(&a);
    printf("POSICAO DOIS -----> %d\n\n",descobreposicao);
    b = fazjogada(&b);
   */
  /*
    c=b;
    a=b;
   
   
    c =acontecejogada0parabaixo(&c);
    
    c = verificah2(&c);
   //lista= add(lista,c);
    
    
    a=acontecejogada0paradireita(&a);
    a = verificah2(&a);
   // lista =add(lista,a);
   
   
    
    
   // lista  = add(lista,c);
    //c =verificah2(&c);
    
     total = calculah2total(&a);
     total3 = calculah2total(&c);
    
     
      if( total>total3)
     {
         b=a;
         printf("AAA\n");
     }
     else{
         b=c;
         printf("BBB\n");
         
     }  
   
  
    
  
    lista  = add(lista,b);
  */
    
    listcompleteofboards(lista);
    a= buscaultimoadicionado(lista);
  
    getchar();
  
  

}
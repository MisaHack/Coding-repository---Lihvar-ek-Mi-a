#include <stdio.h>
#include <math.h>

int main(){
    double P;

    scanf("%lf",&P);

    double r = sqrt(P/M_PI);

    printf("%lf\n", r);

    double rez = 2 * r * M_PI;

    printf("%.5lf", rez);

    return 0;
}

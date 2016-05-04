#!/bin/bash

############
## Test 1 ##
############
sudo ppc64_cpu --dscr=0
for i in `seq 500`
do
numactl --cpunodebind=1 --membind=1 ./jdk8u_my_vsx_pf_miki_vsx/bin/java -Xmx40g -Xms40g ArrayCopyTest1_short |& tee  -a short_my_vsx_pf_miki_vsx_dscr_0.txt;
done

sudo ppc64_cpu --dscr=7
for i in `seq 500`
do
numactl --cpunodebind=1 --membind=1 ./jdk8u_my_vsx_pf_miki_vsx/bin/java -Xmx40g -Xms40g ArrayCopyTest1_short |& tee -a short_my_vsx_pf_miki_vsx_dscr_7.txt;
done

############
## Test 2 ##
############
sudo ppc64_cpu --dscr=0
for i in `seq 500`
do
numactl --cpunodebind=1 --membind=1 ./jdk8u_original/bin/java -Xmx40g -Xms40g ArrayCopyTest1_short |& tee -a short_original_dscr_0.txt;
done

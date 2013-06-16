@ECHO OFF

	java -jar locadoraDVD.jar -comando alugarDVD -d 007 -c 002002 -t 14/06/2013 -v 0,00
	java -jar locadoraDVD.jar -comando consultaCliente -c 002002
	java -jar locadoraDVD.jar -comando selecionaDVD -c 007
	java -jar locadoraDVD.jar -comando devolverDVD -d 007 -c 002002 -t 14/06/2013 -v 7,00
PAUSE
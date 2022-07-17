
#Sistema CRM

##clienti

```
Cliente (
	clienteId!,
	partitaIva, 
	ragioneSociale,
	dataInserimento,
	dataUltimoContatto,
	fatturatoAnnuale,
	pec,
	telefono,
	emailContatto,
	nomeContatto,
	cognomeContatto,
	telefonoContatto,
	indirizziList,
	TipoEnum,
	fattureList
	
```

##clienti.indirizzi
```
Indirizzo(indirizzoId!,
	via,
	civico,
	localita,
	cap,
	Comune,
	clienteId*)
```
##clienti.indirizzi.comuni
```
Comune(comuneId,
	nomeComune
	IndirizziIdList*)
```

##clienti.fatture
```
Fattura(fatturaId,
	anno,
	data,
	importo,
	numero)
```
##clienti.stati
```
statoFatturaID
StatoFattura,
fatturaId*,	// le fatture possono avere un solo stato tra pagata, non pagata, annullata
clienteId*	// allo stato della fattura di un cliente e' associata uno ed un unico cliente e viceversa
```




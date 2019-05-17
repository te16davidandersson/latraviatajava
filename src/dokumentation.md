Jag ska göra om latraviata spelet från webbutvecklingen i java. Jag ska implementera spelet i ett grafiskt gränssnitt
som jag designat med hjälp av intelliJ. Det jag måste göra är att connecta databasen till java genom att använda
connectorn vi fick för ett tag sedan. Efter det måste jag hitta på en till funktion till spelet för att göra det
aningen mer komplicerat.

Möjlig idé som tillägg till spelet:
Spara antalet pengar och pasta alfredo man har i variabler, så att man måste jobba ett tag för att ha råd med pasta
alfredo så att man inte kan äta det oändligt.

Arbetsprocess:
2019-04-05
Skriva planering, jag har gjort ett GUI form till spelet

2019-04-12
Skrev klassdiagram (försökte nästan), lade till connector mellan databasen och java i projektet.

2019-04-19
Problem: När jag ska införa knapparna / texten på knapparna så måste jag veta vilken text som ska in på vilken knapp,
eftersom jag baserar det på storyid och det finns alltid 2 knappar som har samma storyid. Det löste jag genom att kolla
om knappens id är jämnt eller ojämnt genom att kolla om det är delbart med 2, sedan sätta den vänstra knappen till den
som har ojämnt id och högra knappen till den som har jämnt id.

2019-04-26
??????

2019-05-03
Lade till actionlistener till andra knappen
Kommenterade mer kod
Fixade till klassdiagrammen

2019-05-10
sjuk

2019-05-17
Lade till en getter för connector, försökte fixa ett SQL statement som skulle hämta target från min storylinks databas
så att spelet byter story när jag trycker på knapparna. Fick det inte att fungera.
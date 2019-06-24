var http = require('http');
var fs = require('fs');

var recorde = 0;
var array;

console.log("Lendo valores...")
fs.readFile("valores.json", (err, data) =>{
    if(err){
        console.log("Erro ao ler valores.json. Tentando criar um novo...");
        generateValues(data =>{
            array = JSON.parse(data);
            startServer();
        });
    } else {
        try {
            array = JSON.parse(data);    
            console.log("Valores lidos.");
            startServer();
        } catch (error) {
            console.log("O arquivo disponivel não é um array JSON. Deletando e criando um novo...");
            fs.unlink("valores.json", (err) =>{
                if(err){
                    console.log("Não foi possivel deletar :<");
                } else {
                    generateValues(data =>{
                        array = JSON.parse(data);
                        startServer();
                    });                    
                }
            });
        }
        
        
    }
    
    
});



var server = http.createServer(function (req, res) {
    
    console.log("Recebido");
    console.log(req.url);
    if(req.url == "/"){
        //index
        console.log("index");
        res.writeHead(200, {'Content-Type': 'text/html'});
        let htmlStream = fs.createReadStream("index.html");
        htmlStream.pipe(res);
        
    } else if(req.url == "/ajax"){
        var post = "";
        
        req.on("data", (chunk) =>{
            console.log("chunk: " + chunk);
            post += chunk;
        });
        req.on("end", () =>{
            var received = JSON.parse(post);
            const num1 = array[received.num1];
            const num2 = array[received.num2];
            const num3 = array[received.num3];
            const multiplicacao = num1 * num2 * num3;
            if(multiplicacao > recorde){
                recorde = multiplicacao;
            }
            var result = {
                pontuacao: multiplicacao,
                recorde: recorde
            }
            res.writeHead(200, {'Content-Type': 'text/json'});
            res.write(JSON.stringify(result));
            res.end();
        });
       
    } else {
        res.writeHead(404, {'Content-Type': 'text/plain'});
        res.write(`${req.url} Not found`);
        res.end();

    }

  //res.writeHead(200, {'Content-Type': 'text/html'});
  //res.write(req.url);
  
});
function startServer(){
    server.listen(8080, ()=>{
        console.log("Ouvindo na porta 8080");
    });
}

function generateValues(callback){
    let newArray = [];
        for(let i = 0; i < 100; i++){
            newArray[i] = Math.floor(Math.random() * 1000);
        }
        const jsonValues = JSON.stringify(newArray);
        fs.writeFile("valores.json", jsonValues, (error) =>{
            if(error){
                console.log("Nao foi possivel criar novo arquivo. " + error);
            } else {
                console.log("valores.json criado com sucesso");
                
                callback(jsonValues);
            }
        });
}
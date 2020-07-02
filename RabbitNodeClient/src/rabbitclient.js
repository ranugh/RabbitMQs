const amqp = require("amqplib/callback_api");

const conn ="amqp://localhost";


amqp.connect(conn,function(err,channel){
    if(err){
throw err;
    } 


channel.createChannel(function(cherr,channel){
    if(cherr){
        throw cherr;
    } 
    const que_name = "SGQueue1";

    channel.assertQueue(que_name, {
        durable : true
        
    })
    console.log("Waiting for messages :");
    channel.consule(que_name,function(msg){
        console.log("Received :",msg.content.toString());
    }, {noAck : true})
});

});
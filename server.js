const express = require('express');
const mysql = require('mysql');
const cors = require('cors');

const app = express();
app.use(cors());

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "logmastervehicledb"
})

app.post('/Register', (req, res) =>{
    const sql = "INSERT INTO login (`email`, `password`) VALUES (?)";
    const values = [
        req.body.email,
        req.body.password
    ]
    db.query(sql, [values], (err, data)=>{
        if(err){
            return res.json("Error")
        }
        return res.json(data);
    })
})

const PORT = 8080;
app.listen(PORT, () =>{
    console.log(`Listening ${POST}`);
    
})

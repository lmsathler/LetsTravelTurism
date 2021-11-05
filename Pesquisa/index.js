const express = require('express')
const jwt = require('jsonwebtoken')
const app = express()


app.use(express.json())

const SECRET = 'kuhvrcgvdOYLsKasJHdsasdaFshjdgdasdKppoiHdsanm'


// Username e Password
app.post('/servico/login', (req, res) => {
  const username = req.body.username
  const password = req.body.password

  if(username === 'tarley' && password === '123') {
    const token = jwt.sign(
      {id: 01, nome: 'tarley'},
      SECRET,
      {algorithm: 'HS256', expiresIn: 50}
    )
    res.json({
      token: token,
      expiresIn: 50
    })

  } else {
      res.sendStatus(401)
  }
})

// Verificando validação do token
const validarToken = (req, res, next) => {
  const auth = req.headers['authorization']

  if(!auth) {
    return res.sendStatus(401)
  }
  const token = auth.replace('Bearer ', '')

  try {
    jwt.verify(token, SECRET)
    next()

  }catch(err) {
    res.sendStatus(500)
  }
}

// Meu armazenamento de dados
let pesquisasDB = [
  {id: 01, nome : 'João', cpf: '999.999.999.91', email: 'joao40@gmail.com'},
  {id: 02, nome : 'Julia', cpf: '888.888.888.81', email: 'ju01@gmail.com'},
  {id: 03, nome : 'Paulo', cpf: '777.777.777.71', email: 'paulinho2@gmail.com'},
  {id: 04, nome : 'Jhon', cpf: '666.666.666.61', email: 'Jhon001@gmail.com'},
  {id: 05, nome : 'Gabi', cpf: '555.555.555.51', email: 'bibi001@gmail.com'},
  {id: 06, nome : 'Theo', cpf: '444.444.444.41', email: 'theo001@gmail.com'},
]

// Recupera minhas pesquisas
app.get('/servico/pesquisa', validarToken, (req, res) => {
  res.json(pesquisasDB)
})

// Adiciona cadastra novas requisições
app.post('/servico/pesquisa', (req, res) => {
  const pesquisa = req.body

  pesquisasDB.push(pesquisa)

  res.json({mensagem: 'Pesquisa realiazda com sucesso.'})
})

// Deleta minhas pesquisas
app.delete('/servico/pesquisa/:id', (req, res) => {
  const id = req.params.id

  pesquisasDB = pesquisasDB.filter(p => id != id)
  res.json({
    mensagem: 'Pesquisa excluida com sucesso'
  })
})

// Faz alteração nos dados
app.put('/servico/pesquisa/:id', (req, res) => {
  const id = req.params.id
  const novaPesquisa = req.body

  pesquisasDB = pesquisasDB.filter(p => p.id != id)
  pesquisasDB.push(novaPesquisa)

  res.json({
    mensagem: 'Pesquisa alterada com sucesso'
  })
})


app.listen(3000, () => {
  console.log('Serviço Pesquisa em execução porta 3000')
})
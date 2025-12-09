
import React, {useEffect, useState} from 'react'
import axios from 'axios'

export default function App(){
  const [authors, setAuthors] = useState([])
  const [name, setName] = useState('')

  useEffect(()=>{ fetchAuthors() },[])

  function fetchAuthors(){
    axios.get('/api/v1/authors').then(r=>{
      // api returns paged response, but minimal controller returns Page -> shape contains 'content'
      setAuthors(r.data.content || [])
    }).catch(e=>console.error(e))
  }

  function createAuthor(){
    axios.post('/api/v1/authors', { name }).then(()=>{ setName(''); fetchAuthors() })
  }

  return (
    <div style={{padding:20}}>
      <h1>Authors</h1>
      <input value={name} onChange={e=>setName(e.target.value)} placeholder='author name' />
      <button onClick={createAuthor}>Create</button>
      <ul>
        {authors.map(a=> <li key={a.id}>{a.name} ({a.id})</li>)}
      </ul>
    </div>
  )
}

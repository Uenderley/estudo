import React, {useState, useEffect} from 'react';
import api from './services/api';

import './global.css';
import './App.css';
import './Sidebar.css';
import './index.css';

import './components/DevItem/index';
import DevItem from './components/DevItem/index';
import DevForm from './components/DevForm';

//Component = Bloco/Funcao isolado que retorna conteudo. O nome do componente
//            a primeira letra deve ser sempre maiuscula;

//Estado = INformações que um componente pai passa para o componento filho
//Propriedade = INformações mantidas pelo componente (imutabilidade)

function App() {
  const [devs, setDevs] = useState([]);

  useEffect(() => {
    async function loadDevs() {
      const response = await api.get('/devs');

      setDevs(response.data);
    };

    loadDevs();
  }, []);

  async function handleAddDev(data) {
    const response = await api.post('/devs', data);
    setDevs([...devs, response.data]);
  }

  return (
    <div id="app">
      <aside>
        <strong>Cadastrar</strong>
        <DevForm onSubmit={handleAddDev}/>
      </aside>
      <main>
        <ul>
          {devs.map(dev => (
            <DevItem key={dev._id} dev={dev} />
          ))}
        </ul>
      </main>
    </div>
  );
}

export default App;

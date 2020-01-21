import React from 'react';

import './styles.css';

function DevItem({ dev }) {
    return (
        <li className="dev-item">
            <header>
            <img src="https://static5.minhalojanouol.com.br/mundoalviverde/produto/20190205133401_5056994944_D.jpg" alt="Uenderley"></img>
            <div className="user-info">
                <strong>{dev.github_username}</strong>
                <span>{dev.techs.join(', ')}</span>
            </div>
            </header>

            <p>{dev.bio}</p>
            <a href={`https://github.com/${dev.github_username}`}>Acessar perfil</a>
        </li>
    );
}

export default DevItem;
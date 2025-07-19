const totalTurns = 5;
let players = [];

const diceFaces = ['⚀', '⚁', '⚂', '⚃', '⚄', '⚅'];
const grid = document.getElementById("diceGrid");
const statusText = document.getElementById("status");

document.getElementById("playerForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const inputs = e.target.querySelectorAll("input[type=text]");
  const names = Array.from(inputs).slice(0, 4).map(i => i.value.trim() || "Player");

  players = names.map((name, i) => ({
    id: i + 1,
    name,
    rolls: [],
    total: 0,
  }));

  document.getElementById("nameForm").style.display = "none";
  document.getElementById("gameArea").style.display = "block";
  initBoard();
});

document.getElementById("resetBtn")?.addEventListener("click", () => {
  // Reset players and UI
  players = [];
  document.getElementById("gameArea").style.display = "none";
  document.getElementById("nameForm").style.display = "block";
  document.getElementById("playerForm").reset();
  grid.innerHTML = '';
  statusText.textContent = '';
});

function initBoard() {
  grid.innerHTML = "";
  players.forEach((player) => {
    const div = document.createElement("div");
    div.className = "dice-box";
    div.id = `player-${player.id}`;
    div.innerHTML = `
      ${player.name}<br>
      <div class="dice" onclick="roll(${player.id})" id="dice-${player.id}">🎲</div>
      <div id="rolls-${player.id}">0/5</div>
    `;
    grid.appendChild(div);
  });
  updateStatus();
}

function roll(playerId) {
  const player = players[playerId - 1];
  if (player.rolls.length >= totalTurns) return;

  const value = Math.floor(Math.random() * 6);
  const face = diceFaces[value];
  player.rolls.push(value + 1);
  player.total += (value + 1);

  const dice = document.getElementById(`dice-${player.id}`);
  dice.textContent = face;
  dice.style.animation = "none";
  void dice.offsetWidth;
  dice.style.animation = "realSpin 0.6s ease";

  document.getElementById(`rolls-${player.id}`).textContent = `${player.rolls.length}/5`;
  updateStatus();

  if (players.every(p => p.rolls.length === totalTurns)) {
    setTimeout(showResults, 800);
  }
}

function updateStatus() {
  const text = players.map(p => `${p.name}: ${p.rolls.length}/5`).join(" | ");
  statusText.textContent = text;
}

function showResults() {
  const max = Math.max(...players.map(p => p.total));
  const winners = players.filter(p => p.total === max);
  const winnerNames = winners.map(w => w.name).join(", ");

  let html = `<html><head><title>Results</title>
  <style>
    body { font-family: Arial; padding: 20px; background: #2b5876; color: white; }
    h1 { color: #ffd700; }
    h2 { color: #00ffcc; margin-top: 10px; }
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th, td { border: 1px solid #ccc; padding: 10px; text-align: center; background: #4e4376; color: white; }
    th { background: #ff8c00; }
    .winner {
      background: #28a745;
      font-weight: bold;
      color: white;
      border: 3px solid #fff700;
      box-shadow: 0 0 10px #fff700;
    }
  </style>
  </head><body>
  <h1>🎉 Game Results</h1>
  <h2>🏆 Winner${winners.length > 1 ? 's' : ''}: ${winnerNames}</h2>
  <table>
    <tr><th>Player</th><th>Rolls</th><th>Total</th></tr>`;

  players.forEach(p => {
    const isWin = winners.includes(p) ? "winner" : "";
    html += `<tr class="${isWin}">
      <td>${p.name}</td>
      <td>${p.rolls.join(', ')}</td>
      <td>${p.total}</td>
    </tr>`;
  });

  html += `</table></body></html>`;
  const newTab = window.open();
  newTab.document.write(html);
  newTab.document.close();
}

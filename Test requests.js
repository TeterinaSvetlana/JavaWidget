// GET all widgets
fetch('/widgets/').then(response => response.json().then(console.log))

// GET one widget
fetch('/widgets/{id}').then(response => response.json().then(console.log))

// POST new widget
fetch(
  '/widgets',
  {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ x: 150, y: 200, width: 100, hight: 100 })
  }
).then(result => result.json().then(console.log))

// PUT existing widget
fetch(
  '/widgets/{id}',
  {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ x: 1, y: 2, width: 1, hight: 1 })
  }
).then(result => result.json().then(console.log));

// DELETE widget
fetch('/widgets/{id}', { method: 'DELETE' }).then(result => console.log(result))

// POST new area
fetch(
  '/widgets/area',
  {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ x1: 100, y1: 100, x2: 200, y2: 250 })
  }
).then(result => result.json().then(console.log))

// GET all widgets intersecting the area
fetch('/widgets/area').then(response => response.json().then(console.log))
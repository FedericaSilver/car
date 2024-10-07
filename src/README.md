```
# Applicazione Web Spring Boot - Gestione di Entità Car

## Specifiche

Crea una applicazione web Spring Boot con le seguenti caratteristiche:

### Entità `Car`
L'entità `Car` deve avere le seguenti colonne:
- `id`
- `modelName` - **Obbligatorio**
- `type` - **Enum** - **Obbligatorio**
- `color` - **Enum** - **Obbligatorio**
- `description` - `String` - **Non obbligatorio**

### Repository
- Creare un repository dedicato per `Car`.

### Controller
Creare un controller dedicato per `Car` che:
- È mappato su `/cars`
- Esegue le operazioni CRUD:

#### Operazioni CRUD

1. **Crea nuova Car**
2. **Restituisce la lista di tutte le Car**
3. **Restituisce una singola Car** - Se l'`id` non è presente nel database (usa `existsById()`), restituisce `404`
4. **Aggiorna il `type` della Car specifica** identificata da `id` e passando un query param - Se l'`id` non è presente nel database (usa `existsById()`), restituisce `404`
5. **Cancella la Car specifica** - Se non presente, restituisce `404`
6. **Cancella tutte le Car nel database**

## Test delle Endpoints (usando Postman)

1. Crea **due macchine diverse**
2. Prendi **tutte le macchine**
3. Prendi una **macchina usando `id`**
4. Prendi una **macchina non esistente**
5. Aggiorna il **type di una macchina esistente**
6. Aggiorna una **macchina non esistente**
7. Cancella una **macchina esistente**
8. Cancella una **macchina non esistente**
9. Cancella **tutta la base dati**
```
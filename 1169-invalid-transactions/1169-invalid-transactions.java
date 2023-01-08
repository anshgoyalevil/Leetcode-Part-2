class Solution {

    public List<String> invalidTransactions(final String[] transactions) {
        final List<String> invalid = new ArrayList<>();
        final Map<String, List<Transaction>> map = new HashMap<>();

        for (final String transaction : transactions) {
            final Transaction tran = new Transaction(transaction);

            if (map.containsKey(tran.name)) {
                map.get(tran.name).add(tran);
            } else {
                final List<Transaction> list = new ArrayList<>();
                list.add(tran);
                map.put(tran.name, list);
            }
        }

        for (final String transaction : transactions) {
            final Transaction tran = new Transaction(transaction);

            if (!isValid(map.get(tran.name), tran)) {
                invalid.add(transaction);
            }
        }

        return invalid;
    }

    public boolean isValid(final List<Transaction> transactions, final Transaction transaction) {
        if (transactions.size() <= 1 && transaction.amount < 1000) return true;

        for (final Transaction tran : transactions) {
            if (transaction.invalidTransaction(tran.city, tran.time)) {
                return false;
            }
        }
        return true;
    }

    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(final String transaction) {
            final String[] t = transaction.split(",");
            this.name = t[0];
            this.time = Integer.parseInt(t[1]);
            this.amount = Integer.parseInt(t[2]);
            this.city = t[3];
        }

        public boolean invalidTransaction(final String city, final int time) {
            return invalidAmount() || differentCity(city, time);
        }

        private boolean differentCity(final String city, final int time) {
            return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
        }

        private boolean invalidAmount() {
            return this.amount > 1000;
        }
    }
}

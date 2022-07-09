public class Account {
	protected double balance;

	protected Account(double initBalance) {
		balance = initBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amt) {
		balance = balance + amt;
	}

	public void withdraw(double amt) throws OverdraftException {
		if (amt <= balance) {
			balance = balance - amt;
		} else {
			throw new OverdraftException("Dana Anda tidak mencukupi", amt - balance);
		}
	}

	public static void main(String[] args) {
		int i;
		Account[] accounts = new Account[100];
		accounts[0] = new Account(2000000);
		accounts[1] = new Account(0);

		for (i = 0; i < 2; i++) {
			double d = accounts[i].getBalance();
			System.out.println("Saldo akhir akun ke-" + i + " adalah Rp " + d);

			try {
				accounts[i].withdraw(1000000);
			} catch (OverdraftException e) {
				System.out.println("Eksepsi akun ke " + i + " adalah " + e);
			} finally {
				double b = accounts[i].getBalance();
				System.out.println("Saldo setelah diambil 1jt akun ke-" + i + "adalah Rp " + b);
			}
		}
	}
}

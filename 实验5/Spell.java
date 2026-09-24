package t4;


    public enum Spell {
        Fireball("攻击型", 15, 0, 10, 1),
        IceSpike("攻击型", 22, 0, 14, 2),
        ThunderStrike("攻击型", 30, 0, 20, 3),
        LifeHeal("生命恢复型", 0, 20, 8, 1),
        GreaterHeal("生命恢复型", 0, 35, 18, 3),
        HolyBlessing("生命回复型", 0, 50, 28, 5),
        ManaRegen("法力恢复型", 0, 10, 5, 1);

        private final String type;
        private final int damage;
        private final int heal;
        private final int manaCost;
        private final int levelRequired;

        Spell( String type, int damage, int heal, int manaCost, int levelRequired) {
            this.type = type;
            this.damage = damage;
            this.heal = heal;
            this.manaCost = manaCost;
            this.levelRequired = levelRequired;
        }
        public String getName(){
            return this.name();
        }

        public String getType() {
            return type;
        }

        public int getDamage() {
            return damage;
        }

        public int getHeal() {
            return heal;
        }

        public int getManaCost() {
            return manaCost;
        }

        public int getLevelRequired() {
            return levelRequired;
        }
    }

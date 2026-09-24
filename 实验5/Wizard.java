package t4;

import java.util.ArrayList;

public class Wizard {
    public String name;
    public int mana;
    public int healthPoint;
    public int level;
    public ArrayList<Spell> magicBook = new ArrayList<>();
    public int capacity;
    public Wizard(String name,int healthPoint,int mana,int level,int capacity){
        this.name = name;
        this.healthPoint = healthPoint;
        this.mana = mana;
        this.level = level;
        this.capacity = capacity;
    }
    public void learnSpell(Spell spell){
        if(magicBook.size() >= capacity){
          return;
        } else if(spell.getLevelRequired() > this.level){
            return;
        }else{
            magicBook.add(spell);
        }
    } //  学习法术
    public void removeSpellByName (String name){
        this.magicBook.removeIf(spell -> spell.name().equals(name));
    } //根据法术名移除法术
    public ArrayList<Spell> getSpells(){
        return this.magicBook;
    } // 返回所有法术列表
    public Spell findSpellByName(String name){
        return this.magicBook.stream()
                .filter(spell ->spell.name().equals(name))
                .findFirst()
                .orElse(null);
    } // 根据名字查找法术
    public void castHealSpell(String name){
        Spell spell = findSpellByName(name);
        System.out.println(this.name + " 使用了 " + name + " 技能");
        System.out.println("恢复 " + spell.getHeal() + " 血量");
        System.out.println("耗费 " + spell.getManaCost() + " 法力值");
        if(spell.getType().equals("生命恢复型")) {
            this.healthPoint += spell.getHeal();
            this.mana -= spell.getManaCost();
            System.out.println("施展完后，法师血量：" + this.healthPoint + " 法师法力：" + this.mana);
        }else{
            this.mana += spell.getHeal();
            this.mana -= spell.getManaCost();
            System.out.println("施展完后，法师血量：" + this.healthPoint + " 法师法力：" + this.mana);
        }

    }// 施展恢复型法术
    public void castAttackSpell(String name, Monster monster){
        Spell spell = findSpellByName(name);
        System.out.println(this.name + " 对 " + monster.name + " 使用了 " + name + " 攻击 ");
        System.out.println("造成 " + spell.getDamage() + " 伤害");
        System.out.println("耗费 " + spell.getManaCost() + " 法力值");
        monster.healthPoint -= spell.getDamage();
        this.healthPoint -= (int)(spell.getDamage()*0.6);
        this.mana -= spell.getManaCost();
        System.out.println("施展完后，怪物血量：" + monster.healthPoint + (monster.healthPoint <= 0 ? ("\n" + monster.name + " 死亡"):(" ")));
        System.out.println("法师血量：" + this.healthPoint + " 法师法力：" + this.mana);
    }// 施展攻击型法术
    public static void main(String[] args) {
        // 法师信息，姓名wizard，初始血量100，初始法力50，等级3，魔法书容量5
        Wizard wizard =  new Wizard("wizard", 100, 50, 3, 5);
        // 怪兽队伍信息，怪兽1: monster1，血量60；怪兽2: monster2，血量50
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("monster1", 60));
        monsters.add(new Monster("monster2", 50));
        // （可以选择性修改要学习的法术）学习法术
        wizard.learnSpell(Spell.Fireball);
        wizard.learnSpell(Spell.HolyBlessing);
        wizard.learnSpell(Spell.IceSpike);
        wizard.learnSpell(Spell.ThunderStrike);
        wizard.learnSpell(Spell.LifeHeal);
        wizard.learnSpell(Spell.ManaRegen);
        wizard.learnSpell(Spell.GreaterHeal);

        // 打印学习的法术总数与列表
        System.out.println("魔法书包含法术数量：" + wizard.getSpells().size());
        for (Spell spell : wizard.getSpells()) {
            System.out.println("法术名:" + spell.getName() + "; 法术类型:" + spell.getType()+ "; 学习法术所需等级:" + spell.getLevelRequired());
        }
        // 查找法术
        Spell found = wizard.findSpellByName("Fireball");
        if (found != null) {
            System.out.println("已找到：" + found.getName());
        }
        // 移除法术
        wizard.removeSpellByName("Fireball");
        System.out.println("删除后的法术数量：" + wizard.getSpells().size());

        // TODO 请设定法术施展顺序，击垮队伍monsters，
        // 要求：1.打印每一个法术施展情况，以及施展过后怪物的血量、法师的法力、血量情况，最终目标是法师健康，怪物血量为0
        wizard.castAttackSpell("IceSpike",monsters.get(0));
        wizard.castAttackSpell("IceSpike",monsters.get(0));
        wizard.castHealSpell("ManaRegen");
        wizard.castHealSpell("ManaRegen");
        wizard.castAttackSpell("ThunderStrike",monsters.get(0));
        wizard.castHealSpell("ManaRegen");
        wizard.castHealSpell("ManaRegen");
        wizard.castHealSpell("ManaRegen");
        wizard.castHealSpell("ManaRegen");
        wizard.castHealSpell("ManaRegen");
        wizard.castHealSpell("ManaRegen");
        wizard.castAttackSpell("IceSpike",monsters.get(1));
        wizard.castAttackSpell("IceSpike",monsters.get(1));
        wizard.castAttackSpell("IceSpike",monsters.get(1));
    }
}

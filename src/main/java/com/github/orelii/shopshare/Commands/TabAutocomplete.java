package com.github.orelii.shopshare.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabAutocomplete implements TabCompleter {
    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){
        List<String> l = new ArrayList<String>();
        if(cmd.getName().equalsIgnoreCase("shopshare") && args.length >= 0){
            if(sender instanceof Player){
                if ((args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove"))){
                    if (args.length > 2) return l;
                    for (Player p : Bukkit.getOnlinePlayers()){
                        l.add(p.getName());
                    }
                    return l;
                }
                else if (args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("help")){
                    return l;
                }
                l.add("add");
                l.add("remove");
                l.add("list");
                l.add("help");
                l.add("version");
                return l;
            }
        }
        return l;
    }
}


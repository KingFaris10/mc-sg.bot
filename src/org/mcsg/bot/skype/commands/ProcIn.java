package org.mcsg.bot.skype.commands;

import org.mcsg.bot.skype.Permissions;
import org.mcsg.bot.skype.util.ShellCommand;

import com.skype.Chat;
import com.skype.SkypeException;
import com.skype.User;

public class ProcIn implements SubCommand {

	@Override
	public void execute(Chat chat, User sender, String[] args)
			throws Exception {
		if(Permissions.hasPermission(sender, chat, "proc")){
			if(args.length == 2){
				ShellCommand.quietChat(chat, Integer.parseInt(args[0]));
			} else {
				ShellCommand.readToChat(chat, Integer.parseInt(args[0]));
			}
		}
	}

	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsage() {
		// TODO Auto-generated method stub
		return null;
	}

  @Override
  public String getCommand() {
    return "procin";
  }

  @Override
  public String[] getAliases() {
    // TODO Auto-generated method stub
    return null;
  }

}

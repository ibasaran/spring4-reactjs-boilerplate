// src/components/ui/icon-wrapper.tsx
import { type LucideIcon } from 'lucide-react';
import { cn } from '@/lib/utils';

interface IconWrapperProps {
  icon: LucideIcon;
  className?: string;
}

export const IconWrapper = ({ icon: Icon, className }: IconWrapperProps) => {
  return <Icon className={cn('shrink-0', className)} />;
};